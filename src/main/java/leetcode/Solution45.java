package leetcode;

/**
 * @Description:跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 贪心算法，我使用了两次遍历，导致时间超时，但是思想是正确的。
 * 可以使用一次遍历。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/25 22:27
 */
@Hard
public class Solution45 {
    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int[] nums = {9,4,5,4,1,8,1,2,0,7,8,7,0,6,6,1,1,2,5,0,9,8,4,7,9,6,8,1,4,0,8,5,5,3,9,8,1,2,2,3,0,1,3,2,7,9,3,0,1};
        System.out.println(solution45.jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] steps = new int[nums.length];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        steps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i];
            if (i + step >= nums.length - 1) {
                return steps[i] + 1;
            } else {
                for (int j = 1; j <= step; j++) {
                    if (j + i >= steps.length) {
                        return steps[nums.length - 1];
                    }
                    if (steps[i] + 1 < steps[i + j]) {
                        steps[i + j] = steps[i] + 1;
                    }
                }
            }
        }
        return steps[nums.length - 1];
    }

    //第一种解法，从左往右
    public int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    //第二种解法，从右往左
    public int jump2(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

}
