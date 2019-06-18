package leetcode;

import java.util.Stack;

/**
 * @ClassName Solution20
 * @Descirption  有效的括号 简单
 * @Author yizhendong
 * @Date 2019/5/14
 **/
@Easy
public class Solution20 {
    public static void main(String[] args) {
        System.out.println(isValid("{}{}"));
        System.out.println(isValid("{{{{}{{}}}{}"));
        System.out.println(isValid("[{}{}]"));
        System.out.println(isValid("[}]"));
        System.out.println(isValid(""));
    }

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c - '(' == 0 || c - '[' == 0 || c - '{' == 0) {
                stack.push(c);
            } else if (c - ')' == 0) {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(') {
                    stack.pop();
                } else return false;
            } else if (c - ']' == 0) {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '[') {
                    stack.pop();
                } else return false;
            } else if (c - '}' == 0) {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '{') {
                    stack.pop();
                } else return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
