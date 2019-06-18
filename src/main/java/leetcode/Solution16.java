package leetcode;

import java.util.Arrays;

/**
 * @ClassName Solution16
 * @Descirption 最接近的三数之和 medium
 * @Author yizhendong
 * @Date 2019/5/12
 **/
@Medium
public class Solution16 {
    public static void main(String[] args) {
        int[] num = {-4,-1,-1,0,1,2};
        System.out.println(threeSumClosest(num, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }
            }
        }
        return closestNum;
    }
}
