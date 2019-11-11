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
        Stack<Character> stack = new Stack<Character>();
        System.out.println(newIsValid("{}{}"));
        System.out.println(newIsValid("{{{{}{{}}}{}"));
        System.out.println(newIsValid("[{}{}]"));
        System.out.println(newIsValid("[}]"));
        System.out.println(newIsValid(""));
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

    public static boolean newIsValid(String s) {
        if(s == null) return false;
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<len;i++){
            char curChar = s.charAt(i);
            if(curChar - '(' == 0 || curChar - '[' == 0 || curChar - '{' == 0){
                stack.push(curChar);
            } else if(stack.isEmpty()) {
                return false;
            } else {
                if(curChar - ')' == 0  && stack.peek() - '(' == 0) stack.pop();
                else if(curChar - ']' == 0  && stack.peek() - '[' == 0) stack.pop();
                else if(curChar - '}' == 0  && stack.peek() - '{' == 0) stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
