package 面试;

/**
 * @Author: Young
 * @Date: 2025/11/28 01:54
 */
public class PrintABC {
    private int num;
    private static final Object lock = new Object();

    private void printABC(int targetNum) {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (num % 3 != targetNum) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                lock.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        new Thread(() -> printABC.printABC(0), "A").start();
        new Thread(() -> printABC.printABC(1), "B").start();
        new Thread(() -> printABC.printABC(2), "C").start();
    }
}
