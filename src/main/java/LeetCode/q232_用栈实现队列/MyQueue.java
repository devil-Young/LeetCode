package LeetCode.q232_用栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Young
 * @Date: 2025/12/16 19:19
 */
public class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();

    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();

    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

}
