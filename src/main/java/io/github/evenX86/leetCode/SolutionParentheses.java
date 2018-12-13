package io.github.evenX86.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SolutionParentheses {
    public static boolean isValid(String s) {

        if (s == null || s.length() == 0) return true;
        final Map<Character, Character> chMap = new HashMap<Character, Character>() {
            {
                put('}','{');
                put(']','[');
                put(')','(');
            }
        };
        Stack<Character> stack = new Stack<Character>();
        for (int i =0 ;i <s.length(); i ++) {
            char ch = s.charAt(i);
            if (!chMap.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || stack.pop() != chMap.get(ch)){
                return false;
            }
        }
        return stack.empty();

    }
    public static void main(String[] args) {
        System.out.println(isValid("]"));

    }
}
