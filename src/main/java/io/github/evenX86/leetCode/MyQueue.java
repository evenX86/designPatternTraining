package io.github.evenX86.leetCode;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inputStack = new Stack<Integer>();
        outputStack = new Stack<Integer>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outputStack.empty()) {
            return outputStack.pop();
        }
        while (!inputStack.empty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!outputStack.empty()) {
            return outputStack.peek();
        }
        while (!inputStack.empty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.empty() && outputStack.empty();

    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
