package 面试;

/**
 * @Author: Young
 * @Date: 2025/11/28 14:27
 */

public class PrintABC2 implements Runnable {
    private Thread beforeThread;

    public PrintABC2(Thread beforeThread) {
        this.beforeThread = beforeThread;
    }


    @Override
    public void run() {
        if (beforeThread != null) {
            try {
                beforeThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName());

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread threadA = new Thread(new PrintABC2(null), "A");
            Thread threadB = new Thread(new PrintABC2(threadA), "B");
            Thread threadC = new Thread(new PrintABC2(threadB), "C");

            threadA.start();
            threadB.start();
            threadC.start();
            threadC.join();
        }

    }
}