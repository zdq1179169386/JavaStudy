package com.zdq;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    private HashMap<Character,Character> map = new HashMap<>();
    public Solution() {
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
    }

    public  boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.map.containsKey(c)){
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                char right = this.map.get(left);
                if (c != right)  return false;
            }
        }
        return stack.isEmpty();
    }

    public  boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.map.containsKey(c)){
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (c != map.get(top)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    //移除无效的括号
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] invalidIndex = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                invalidIndex[i] = true;
                stack.push(i);
            } else  if(c == ')') {
                if (stack.isEmpty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[stack.pop()] = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndex[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
