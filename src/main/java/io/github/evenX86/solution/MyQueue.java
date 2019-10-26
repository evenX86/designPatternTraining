package io.github.evenX86.solution;

import java.util.Stack;

/**
 * 双栈实现队列
 *  * Your MyQueue object will be instantiated and called as such:
 *  * MyQueue obj = new MyQueue();
 *  * obj.push(x);
 *  * int param_2 = obj.pop();
 *  * int param_3 = obj.peek();
 *  * boolean param_4 = obj.empty();
 * @author xuyifei
 */
public class  MyQueue<T> {

    private Stack<T> inputStack;
    private Stack<T> outputStack;
    /** Initialize your data structure here. */
    public  MyQueue() {
        inputStack = new Stack<T>();
        outputStack = new Stack<T>();

    }

    /** Push element x to the back of queue. */
    public void push(T x) {
        inputStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public T pop() {
        if (!outputStack.empty()) {
            return outputStack.pop();
        }
        while (!inputStack.empty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }

    /** Get the front element. */
    public T peek() {
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
        MyQueue queue = new MyQueue<String>();

        queue.push("2");
        queue.push("3");
        System.out.println(queue.peek());
        queue.push("1");
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
