package leetcode;

import java.util.Stack;

/**
 * @Description:接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 * 第一种解法：暴力解法，时间复杂度 O（n2），空间复杂度O（1）依次循环，循环的同时，依次找到迭代值所在的左右两边最大值中的较小值，和迭代值做减法，累加得到的差值即可。
 * 第二种解法：动态规划，时间复杂度O(n)，空间复杂度O（n），使用两个数组，分别保存位置i时，左边最大值和邮编最大值，不用再迭代的时候再次循环。
 * 第三种解法：栈的应用，时间复杂度O（n），空间复杂度O（n）。
 * 第四种解法：双指针，时间复杂度O(n),空间复杂度O（1）。暂时没搞明白
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/23 21:21
 */
@Hard
@TriedButFaild
public class Solution42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap(height));
        System.out.println(solution42.trap2(height));
        System.out.println(solution42.trap3(height));
        System.out.println(solution42.trap5(height));
    }

    public int trap(int[] height) {
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = height[i];
            int rightMax = height[i];
            for (int left = i; left >= 0; left--) {
                leftMax = Math.max(height[left], leftMax);
            }

            for (int right = i; right < height.length; right++) {
                rightMax = Math.max(height[right], rightMax);
            }
            count = count + Math.min(rightMax, leftMax) - height[i];

        }
        return count;
    }

    public int trap2(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int count = 0;
        for (int i = 0; i < height.length; i++) {
            count = count + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return count;
    }

    /**
     * 使用类似有效括号的方法来计算
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()){
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    public int trap4(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    public int trap5(int[] height) {
        if(height == null || height.length == 0) return 0;
        int[] leftMax = new int[height.length];
        int max = height[0];
        for(int i = 0;i<height.length;i++){
            if(max <= height[i]){
                max = height[i];
            }
            leftMax[i] = max;
        }
        int[] rightMax = new int[height.length];
        max = height[height.length - 1];
        for(int i = height.length - 1;i>= 0;i--){
            if(max <= height[i]){
                max = height[i];
            }
            rightMax[i] = max;
        }
        int total = 0;
        for(int i = 0;i<height.length;i++){
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return total;
    }
}
