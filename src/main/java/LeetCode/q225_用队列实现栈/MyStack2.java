package LeetCode.q225_用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Young
 * @Date: 2025/12/16 19:10
 *
 * 一个队列
 */
public class MyStack2 {

    Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }

    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
