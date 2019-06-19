package leetcode;

import java.nio.charset.MalformedInputException;

/**
 * @Description:搜索插入位置 https://leetcode-cn.com/problems/search-insert-position/
 * 比较简单，一次通过，花费12分钟
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/19 23:22
 */
@Easy
public class Solution35 {
    public static void main(String[] args) {
        int[] num = {1,3,5,6};
        System.out.println(searchInsert(num, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        return middleSearch(nums, 0, nums.length - 1, target);
    }

    private static int middleSearch(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (nums[start] >= target) return start;
        else if (nums[end] == target) return end;
        else if (nums[end] < target ) return end + 1;
        else if (nums[middle] == target) return middle;
        else if (nums[middle] > target) {
            return middleSearch(nums, start, middle - 1, target);
        } else {
            return middleSearch(nums, middle + 1, end, target);
        }
    }
}
