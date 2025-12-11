package 面试;

/**
 * @Author: Young
 * @Date: 2025/11/29 03:48
 */

import java.io.RandomAccessFile;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 分布式文件处理节点
 */


//public class DistributedFileWorker {
//
//    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB
//    private static final int MAX_RETRY = 3;
//    private static final ExecutorService executor = Executors.newFixedThreadPool(
//            Runtime.getRuntime().availableProcessors() * 2
//    );
//
//    private static final String REDIS_TASK_KEY = "file_tasks";
//
//    private final Jedis redis;
//
//    public DistributedFileWorker(Jedis redis) {
//        this.redis = redis;
//    }
//
//    public void start() {
//        while (true) {
//            String taskJson = redis.lpop(REDIS_TASK_KEY);
//            if (taskJson == null) {
//                try {
//                    Thread.sleep(1000); // 没有任务等待
//                } catch (InterruptedException ignored) {}
//                continue;
//            }
//
//            FileChunkTask task = FileChunkTask.fromJson(taskJson);
//
//            CompletableFuture.runAsync(() -> processTaskWithRetry(task, MAX_RETRY), executor);
//        }
//    }
//
//    private void processTaskWithRetry(FileChunkTask task, int maxRetry) {
//        int attempt = 0;
//        while (attempt < maxRetry) {
//            try {
//                processChunk(task);
//                task.status = "SUCCESS";
//                updateTaskStatus(task);
//                return;
//            } catch (Exception e) {
//                attempt++;
//                logWarn(task, attempt, e);
//                if (attempt >= maxRetry) {
//                    task.status = "FAIL";
//                    updateTaskStatus(task);
//                    logError(task, e);
//                }
//            }
//        }
//    }
//
//    private void processChunk(FileChunkTask task) throws Exception {
//        Path path = Paths.get(task.filePath);
//        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "r")) {
//            raf.seek(task.offset);
//            byte[] buffer = new byte[task.length];
//            int read = raf.read(buffer);
//            if (read > 0) {
//                businessProcess(Arrays.copyOf(buffer, read));
//            }
//        }
//    }
//
//    /** 模拟业务处理 */
//    private void businessProcess(byte[] chunk) throws Exception {
//        Thread.sleep(50); // 模拟耗时处理
//        // 可扩展：解析、转换、入库
//    }
//
//    /** 更新任务状态到 Redis */
//    private void updateTaskStatus(FileChunkTask task) {
//        redis.hset("file_chunk_status", task.id, task.status);
//    }
//
//    private void logError(FileChunkTask task, Throwable ex) {
//        System.err.println("[ERROR] 文件块失败: " + task + ", 异常: " + ex.getMessage());
//        // 企业可扩展：告警
//    }
//
//    private void logWarn(FileChunkTask task, int attempt, Throwable ex) {
//        System.out.println("[WARN] 文件块重试 " + attempt + " 次: " + task + ", 异常: " + ex.getMessage());
//    }
//
//    /** 文件块任务 */
//    static class FileChunkTask {
//        String id;          // 文件+块唯一标识
//        String filePath;
//        long offset;
//        int length;
//        String status;      // PENDING / PROCESSING / SUCCESS / FAIL
//
//        public static FileChunkTask fromJson(String json) {
//            // 简单反序列化，可用 Jackson/Gson
//            String[] parts = json.split(",");
//            FileChunkTask task = new FileChunkTask();
//            task.id = parts[0];
//            task.filePath = parts[1];
//            task.offset = Long.parseLong(parts[2]);
//            task.length = Integer.parseInt(parts[3]);
//            task.status = parts[4];
//            return task;
//        }
//
//        public String toJson() {
//            return String.join(",", id, filePath, String.valueOf(offset), String.valueOf(length), status);
//        }
//
//        @Override
//        public String toString() {
//            return "FileChunkTask{" +
//                    "id='" + id + '\'' +
//                    ", filePath='" + filePath + '\'' +
//                    ", offset=" + offset +
//                    ", length=" + length +
//                    ", status='" + status + '\'' +
//                    '}';
//        }
//    }
//
//    /** 分片任务生成器 */
//    public static List<FileChunkTask> splitFileToTasks(String filePath) throws Exception {
//        Path path = Paths.get(filePath);
//        long fileSize = Files.size(path);
//        List<FileChunkTask> tasks = new ArrayList<>();
//        long offset = 0;
//        int idx = 0;
//        while (offset < fileSize) {
//            int len = (int) Math.min(CHUNK_SIZE, fileSize - offset);
//            FileChunkTask task = new FileChunkTask();
//            task.id = filePath + "_" + idx++;
//            task.filePath = filePath;
//            task.offset = offset;
//            task.length = len;
//            task.status = "PENDING";
//            tasks.add(task);
//            offset += len;
//        }
//        return tasks;
//    }
//
//    public static void main(String[] args) throws Exception {
//        Jedis redis = new Jedis("localhost", 6379);
//
//        // 假设调度中心将文件任务拆分放入 Redis 队列
//        List<String> files = List.of("file1.txt", "file2.txt");
//        for (String file : files) {
//            List<FileChunkTask> tasks = splitFileToTasks(file);
//            for (FileChunkTask task : tasks) {
//                redis.rpush(REDIS_TASK_KEY, task.toJson());
//            }
//        }
//
//        // 启动工作节点
//        new DistributedFileWorker(redis).start();
//    }
//}

