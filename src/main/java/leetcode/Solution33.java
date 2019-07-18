package leetcode;

/**
 * @Description: 搜索旋转排序数组
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/18 23:13
 */
@Medium
public class Solution33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return middleSearch(0, nums, nums.length - 1, target);
    }

    private static int middleSearch(int start, int[] nums, int end, int target) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (nums[middle] == target) return middle;
        else if (nums[start] == target) return start;
        else if (nums[end] == target) return end;
        else if (nums[start] < target || nums[middle] > target) return middleSearch(start, nums, end - 1, target);
        else return middleSearch(middle + 1, nums, end, target);
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 3, 4};
        int target = 1;
        System.out.println(search(nums, target));
    }
}
