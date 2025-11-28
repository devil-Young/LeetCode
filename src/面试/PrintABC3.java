package 面试;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Young
 * @Date: 2025/11/28 15:07
 */
public class PrintABC3 {
    private int num;
    private Lock lock = new ReentrantLock();

    private void printABC(int targetNum) {
        for (int i = 0; i < 10; ) {
            lock.lock();
            if (num % 3 == targetNum) {
                System.out.print(Thread.currentThread().getName());
                num++;
                i++;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABC3 printABC3 = new PrintABC3();

        new Thread(() -> {
            printABC3.printABC(0);
        }, "A").start();

        new Thread(() -> {
            printABC3.printABC(1);
        }, "B").start();

        new Thread(() -> {
            printABC3.printABC(2);
        }, "C").start();
    }
}
