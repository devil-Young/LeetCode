package 面试;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Young
 * @Date: 2025/11/28 15:18
 */
public class PrintABC4 {
    private int num;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    private void printABC(int targetNum, Condition currentThread, Condition nextThread) {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (num % 3 != targetNum) {
                    currentThread.await();  //阻塞当前线程
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                nextThread.signal();    //唤醒下一个线程，而不是唤醒所有线程
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC4 print = new PrintABC4();
        new Thread(() -> {
            print.printABC(0, c1, c2);
        }, "A").start();
        new Thread(() -> {
            print.printABC(1, c2, c3);
        }, "B").start();
        new Thread(() -> {
            print.printABC(2, c3, c1);
        }, "C").start();
    }
}
