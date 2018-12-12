package io.github.evenX86.leetCode;

import java.util.Stack;

public class SolutionParentheses {
    public static boolean isValid(String s) {

        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i =0 ;i <s.length(); i ++) {
            char ch = s.charAt(i);
            if (stack.empty()) {
                stack.push(ch);
                continue;
            }
            Character character = stack.peek();
            if (
                    (ch == '}' && character == '{') ||
                    (ch == ']' && character == '[') ||
                    (ch == ')' && character == '(')
             ) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.empty()) return true;
        return false;

    }
    public static void main(String[] args) {
        System.out.println(isValid(""));

    }
}
