package com.zdq;

import java.util.Stack;

//用栈实现队列
public class MyQueue {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();
    public MyQueue() {
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()){
           return inStack.firstElement();
        } else {
            return outStack.peek();
        }
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
