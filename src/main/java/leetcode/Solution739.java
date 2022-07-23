package leetcode;

import java.util.Stack;

/**
 * @Description: 两种方法都一次解决出来，不是很难
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/17 16:12
 */
@Medium
public class Solution739 {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 solution739 = new Solution739();
        for (int i = 0; i < solution739.dailyTemperatures(T).length; i++) {
            System.out.println(solution739.dailyTemperatures1(T)[i]);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return T;
        int[] result = new int[T.length];
        result[result.length - 1] = 0;
        for (int i = 0; i < T.length - 1; i++) {
            int index = 1;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] <= T[i]) {
                    index++;
                } else {
                    result[i] = index;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) return T;
        Stack<Integer> indexStack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (indexStack.isEmpty()){
                indexStack.push(i);
            } else {
                while (!indexStack.isEmpty()){
                    int number = T[indexStack.peek()];
                    if (number < T[i]){
                        result[indexStack.peek()] = i - indexStack.peek();
                        indexStack.pop();
                        if (indexStack.isEmpty()){
                            indexStack.push(i);
                        }
                    } else {
                        indexStack.push(i);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
