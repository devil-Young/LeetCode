package DesignPattern.结构型模式.适配器;

import java.util.concurrent.Callable;

/**
 * @Author: Young
 * @Date: 2025/12/14 22:37
 */
public class Task implements Callable<Long> {

    private long num;

    public Task(long num) {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }

    public static void main(String[] args) {
        Callable<Long> task = new Task(1234L);
//        Thread thread = new Thread(callable); // Thread只能callable 不能直接传入Thread
        new Thread(new RunnableAdapter(task)).start();
    }
}
