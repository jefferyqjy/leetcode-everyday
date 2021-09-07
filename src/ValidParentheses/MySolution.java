package ValidParentheses;

import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/valid-parentheses/
 * @author: jefferyqjy
 * @datetime: 2021/9/7 15:22
 */
public class MySolution {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        Stack stack = new Stack();
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(current);
            } else {
                char peek = (char) stack.peek();
                if ((current == ')' && peek == '(') || (current == ']' && peek == '[') || (current == '}' && peek == '{')) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            }
        }

        return stack.isEmpty();
    }
}
