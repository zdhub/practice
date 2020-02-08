package leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution15
 * @Descirption 三数之和 https://leetcode-cn.com/problems/3sum/ medium  考虑了很久才完整做出来，主要时间话在排除0相关的case以及重复值的相关case
 * @Author yizhendong
 * @Date 2019/5/12
 **/
@Slf4j
@Medium
public class Solution15 {
    public static void main(String[] args) {
        //-4,-1,-1,0,1,2
        int[] num = {-4,-1,-1,0,1,2};
        System.out.println(threeSum(num));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        if (nums[0] >= 1) return result;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0|| nums[i-1] != nums[i]) && nums[i] == 0 && nums[i + 1] == 0 && nums[i+2] == 0){
                List<Integer> toAdd = new ArrayList<>();
                toAdd.add(nums[i]);
                toAdd.add(nums[i+1]);
                toAdd.add(nums[i+2]);
                result.add(toAdd);
                i=i+2;
                continue;
            } else if (i > 0 && nums[i]== nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    List<Integer> toAdd = new ArrayList<>();
                    toAdd.add(nums[i]);
                    toAdd.add(nums[start]);
                    toAdd.add(nums[end]);
                    result.add(toAdd);
                    start++;
                    end--;
                    while (start < nums.length - 1 && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (end > 0 && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
                if (start < nums.length - 1 && end > 0 && nums[start] + nums[end] < target) {
                    start++;
                }
                if (start < nums.length - 1 && end > 0 && nums[start] + nums[end] > target) {
                    end--;
                }

            }
        }
        return result;
    }

    //别人的方法，非常简单
    //第二次来看，还是非常简单
    public static List<List<Integer>> newThreeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            //这一步非常妙啊
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        //这两步也非常妙啊，都可以跳过重复的值
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
        return ls;
    }
}
