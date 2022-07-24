package leetcode;

/**
 * @Description:Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/24
 * @Time:15:16
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], maxEndingHere = nums[0];
        int index = 1;
        while(index < nums.length){
            maxEndingHere = Math.max(nums[index] + maxEndingHere, nums[index]);
            maxSum = Math.max(maxEndingHere, maxSum);
            index++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(nums));
    }
}
