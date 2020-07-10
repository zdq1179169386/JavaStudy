package com.zdq;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackHelp = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (stackHelp.isEmpty()) {
            stackHelp.push(x);
        } else {
            stackHelp.push(Math.min(stackHelp.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        stackHelp.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return stackHelp.peek();
    }
}
