package leetcode;

import java.util.Stack;

/**
 * 整体不是特别复杂，但是不是很熟练
 * 2022年7月13日
 */
@Medium
public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(popped == null) return true;
        if(pushed == null) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int pushIndex = 0;
        int popIndex = 0;
        while(popIndex < popped.length){
            if(stack.size() == 0 || stack.peek() != popped[popIndex]){
                if(pushIndex >= pushed.length) return false;
                stack.push(pushed[pushIndex]);
                pushIndex++;
            } else {
                stack.pop();
                popIndex++;
            }
        }
        return true;
    }
}
