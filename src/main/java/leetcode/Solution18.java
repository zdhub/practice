package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution18
 * @Descirption  四数之和 medium  https://leetcode-cn.com/problems/4sum/
 * @Author yizhendong
 * @Date 2019/5/12
 **/
@Medium
public class Solution18 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        System.out.println(fourSum(nums, 0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length < 4) return result;
        for (int k = 0;k<nums.length - 3;k++){
            if (k == 0 || (k > 0 && nums[k] != nums[k - 1]))
            for (int i = k+1; i < nums.length - 2; i++) {
                if (i == k + 1 || (i > k + 1 && nums[i] != nums[i - 1])){
                    int l = i + 1, r = nums.length - 1, sum = target - nums[i] - nums[k];
                    while (l < r) {
                        if (nums[l] + nums[r] == sum) {
                            result.add(Arrays.asList(nums[i], nums[l], nums[r], nums[k]));
                            while (l < r && nums[l] == nums[l + 1]) l++;
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            l++;
                            r--;
                        } else if (nums[l] + nums[r] < sum) {
                            while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                            l++;
                        } else {
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            r--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
