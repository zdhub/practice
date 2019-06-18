package leetcode;

import java.util.Stack;

/**
 * @ClassName Solution32
 * @Descirption https://leetcode-cn.com/problems/longest-valid-parentheses/ 最长有效括号
 * @Author yizhendong
 * @Date 2019/6/6
 **/
@Hard
@TriedButFaild
public class Solution32 {
    public static void main(String[] args) {

    }

    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
