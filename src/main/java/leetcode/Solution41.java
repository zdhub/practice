package leetcode;

/**
 * @Description: 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * https://leetcode-cn.com/problems/first-missing-positive/
 * 关键是要是用时间复杂度应为O(n)的算法，并且只能使用常数级别的空间
 * 由于是On的时间复杂度，所以只能遍历一遍。本题需要充分利用数组的下标和数值的关系来处理。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/23 19:03
 */
@Hard
@TriedButFaild
public class Solution41 {
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        int[] nums = {3,4,-1,1};
        System.out.println(solution41.firstMissingPositive(nums));
    }

    private int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1) i++;
            else if (nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
            else i++;
        }

        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int myFirstMissingPositive(int[] nums) {
        Integer min = Integer.MAX_VALUE;
        Integer max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i] && max <= nums.length) {
                max = nums[i];
            }
        }
        if (min > 1) return 1;
        if (max != Integer.MAX_VALUE) max = max + 1;
        Boolean[] exit = new Boolean[max];
        for (int i = 0; i < exit.length; i++) {
            exit[i] = false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] >= exit.length) continue;
            exit[nums[i]] = true;
        }

        for (int i = 1; i < exit.length; i++) {
            if (!exit[i]) return i;
        }
        return exit.length;
    }
}
