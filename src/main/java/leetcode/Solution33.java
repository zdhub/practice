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
        return middleSearch(0, nums, nums.length - 1, target);
    }

    private static int middleSearch(int start, int[] nums, int end, int target) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (nums[middle] == target) return middle;
        else if (nums[middle] < target) return middleSearch(middle + 1, nums, end, target);
        else return middleSearch(start, nums, end - 1, target);
    }

    public static void main(String[] args) {
        int[] nums = {5,6,7,1,2,3,4};
        int target = 5;
        System.out.println(search(nums, target));
    }
}
