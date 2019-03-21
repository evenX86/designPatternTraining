package io.github.evenX86.solution;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> inQ;
    private Queue<Integer> outQ;


    /** Initialize your data structure here. */
    public MyStack() {
        inQ = new LinkedList<Integer>();
        outQ = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQ.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int val = 0;
        while (!inQ.isEmpty()) {
            val = inQ.poll();
            if (inQ.isEmpty()) break;
            outQ.add(val);
        }
        while (!outQ.isEmpty()) {
            inQ.add(outQ.poll());
        }
        return val;
    }

    /** Get the top element. */
    public int top() {
        int val = 0;
        while (!inQ.isEmpty()) {
            val = inQ.poll();
            outQ.add(val);
        }
        while (!outQ.isEmpty()) {
            inQ.add(outQ.poll());
        }
        return val;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQ.isEmpty() && outQ.isEmpty();
    }
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}
