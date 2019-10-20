package io.github.evenX86.solution;

import java.util.Stack;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-08-13 8:06 AM
 */
public class SolutionA {
    public boolean isValid(String s) {
        if (s == null || s.length()<=0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            Character character = s.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            }
            if (character == '}' || character == ')' || character == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character characterLeft = stack.pop();
                if (character == '}' && characterLeft == '{') {
                    continue;
                }
                if (character == ')' && characterLeft == '(') {
                    continue;
                }
                if (character == ']' && characterLeft == '[') {
                    continue;
                }
                return false;

            }
        }

        return stack.isEmpty();
    }
}
