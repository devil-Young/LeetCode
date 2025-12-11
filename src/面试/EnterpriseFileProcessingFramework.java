package 面试;

/**
 * @Author: Young
 * @Date: 2025/11/29 03:50
 */
import java.io.RandomAccessFile;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class EnterpriseFileProcessingFramework {

    // 企业级线程池，可动态扩展
    private static final ExecutorService executor = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * 2
    );

    // 配置
    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB
    private static final int MAX_RETRY = 3;

    public static void main(String[] args) {
        List<String> files = List.of("file1.txt", "file2.txt", "file3.txt");

        List<CompletableFuture<ProcessingResult>> futures = files.stream()
                .map(file -> CompletableFuture.supplyAsync(() -> processFileWithRetry(file, MAX_RETRY), executor)
                        .handle((res, ex) -> {
                            if (ex != null) {
                                logError(file, ex);
                                return ProcessingResult.failure(file, ex);
                            }
                            return res;
                        })
                )
                .collect(Collectors.toList());

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allDone.join();

        // 收集结果
        List<ProcessingResult> results = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // 输出统计
        long successCount = results.stream().filter(r -> r.success).count();
        long failCount = results.size() - successCount;

        System.out.println("总文件数：" + results.size() + ", 成功：" + successCount + ", 失败：" + failCount);
        results.forEach(System.out::println);

        executor.shutdown();
    }

    /** 文件处理带重试 */
    private static ProcessingResult processFileWithRetry(String filePath, int maxRetry) {
        int attempt = 0;
        while (attempt < maxRetry) {
            try {
                return processFileWithResume(filePath);
            } catch (Exception e) {
                attempt++;
                logWarn(filePath, attempt, e);
                if (attempt >= maxRetry) {
                    throw new RuntimeException("文件处理失败超过最大重试次数：" + filePath, e);
                }
            }
        }
        return ProcessingResult.failure(filePath, new RuntimeException("未知错误"));
    }

    /** 文件处理，支持断点续传 */
    private static ProcessingResult processFileWithResume(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        Path progressFile = Paths.get(filePath + ".progress");

        long lastProcessed = 0;
        if (Files.exists(progressFile)) {
            lastProcessed = Long.parseLong(Files.readString(progressFile));
        }

        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "r")) {
            raf.seek(lastProcessed);
            byte[] buffer = new byte[CHUNK_SIZE];
            int read;
            while ((read = raf.read(buffer)) != -1) {
                // 业务处理
                businessProcess(Arrays.copyOf(buffer, read));

                lastProcessed += read;
                Files.writeString(progressFile, String.valueOf(lastProcessed),
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        }

        // 文件处理完成，删除进度文件
        Files.deleteIfExists(progressFile);
        return ProcessingResult.success(filePath);
    }

    /** 业务处理接口，可扩展 */
    private static void businessProcess(byte[] chunk) throws Exception {
        // 模拟耗时业务逻辑
        Thread.sleep(50);
        // 可以在这里做解析、转换、入库等
    }

    private static void logError(String filePath, Throwable ex) {
        System.err.println("[ERROR] 文件处理失败: " + filePath + ", 异常: " + ex.getMessage());
        // 企业可扩展：发邮件/钉钉/消息队列告警
    }

    private static void logWarn(String filePath, int attempt, Throwable ex) {
        System.out.println("[WARN] 文件处理重试 " + attempt + " 次: " + filePath + ", 异常: " + ex.getMessage());
    }

    static class ProcessingResult {
        String file;
        boolean success;
        Throwable error;

        private ProcessingResult(String file, boolean success, Throwable error) {
            this.file = file;
            this.success = success;
            this.error = error;
        }

        public static ProcessingResult success(String file) {
            return new ProcessingResult(file, true, null);
        }

        public static ProcessingResult failure(String file, Throwable error) {
            return new ProcessingResult(file, false, error);
        }

        @Override
        public String toString() {
            return "ProcessingResult{" +
                    "file='" + file + '\'' +
                    ", success=" + success +
                    ", error=" + (error != null ? error.getMessage() : "none") +
                    '}';
        }
    }
}

