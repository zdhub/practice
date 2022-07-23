package leetcode;

import java.util.HashMap;

/**
 * @ClassName Solution1
 * @Descirption 两数之和 一遍遍历，使用hash，时间复杂度和空间复杂度都是O(N)
 * @Author yizhendong
 * @Date 23/1/2020
 **/
@Easy
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(hashmap.containsKey(target - nums[i])){
                int[] result = new int[2];
                result[0] = i;
                result[1] = hashmap.get(target - nums[i]);
                return result;
            }
            hashmap.put(nums[i], i);
        }
        return null;
    }
}
