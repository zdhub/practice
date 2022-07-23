package leetcode;

import java.util.Stack;

/**
 * @Description:
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/11 22:44
 */
public class Solution84 {
    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        int[] number = {0, 9};
        System.out.println(solution84.largestRectangleArea4(number));
    }

    /**
     * 暴力法 时间复杂度O(n3),空间复杂度O(1)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int result = heights[0];
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int min = heights[j];
                for (int k = i; k < j; k++) {
                    if (heights[k] < min) {
                        min = heights[k];
                    }
                }
                result = Math.max(result, min * (j - i + 1));
            }
        }
        return result;
    }

    /**
     * 优化后的暴力法 时间复杂度O(n2), 空间复杂度O(1)
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int result = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                result = Math.max(result, min * (j - i + 1));
            }
        }
        return result;
    }

    /**
     * 分而治之 时间复杂度O(nlogn) 空间复杂度O(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        return getArea(heights, 0, heights.length - 1);
    }

    private int getArea(int[] heights, int start, int end) {
        if (start > end) return 0;
        int min = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[min]) {
                min = i;
            }
        }
        int minValue = Math.max(getArea(heights, start, min - 1), getArea(heights, min + 1, end));
        return Math.max(heights[min] * (end - start + 1), minValue);
    }

    /**
     * 栈
     * @param heights
     * @return
     */
    public int largestRectangleArea4(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0;i<heights.length;i++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i -stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
