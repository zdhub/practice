package leetcode;

import java.util.Arrays;

/**
 * @Description:在排序数组中查找元素的第一个和最后一个位置,时间复杂度必须是O(log n) 级别
 * url:https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 2019年6月19日一次通过，耗费时间20分钟左右
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/19 22:47
 */

@Medium
public class Solution34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        Arrays.stream(searchRange(nums, 10)).forEach(i->System.out.println(i));
    }

    public static int[] searchRange(int[] nums, int target) {

        return middleSearch(nums, 0, nums.length - 1, target);
    }

    private static int[] middleSearch(int[] nums, int start, int end, int target) {
        int[] result = new int[2];
        int middle = (start + end) / 2;
        if (start > end || nums[0] > target || nums[end] < target) {
            result[0] = -1;
            result[1] = -1;
            return result;
        } else if (nums[start] == target || nums[end] == target || nums[middle] == target) {
            int tempStart = 0;
            int tempEnd = 0;
            if (nums[start] == target) {
                tempEnd = start;
                tempStart = start;
            } else if (nums[end] == target) {
                tempEnd = end;
                tempStart = end;
            } else {
                tempEnd = middle;
                tempStart = middle;
            }
            while (tempStart >= 0) {
                if (nums[tempStart] == target) tempStart--;
                else break;
            }
            result[0] = tempStart + 1;
            while (tempEnd <= nums.length - 1) {
                if (nums[tempEnd] == target) tempEnd++;
                else break;
            }
            result[1] = tempEnd - 1;
            return result;
        } else if (nums[middle] > target) {
            return middleSearch(nums, start, middle - 1, target);
        } else {
            return middleSearch(nums, middle + 1, end, target);
        }
    }
}
