package leetcode;

/**
 * @ClassName Solution31
 * @Descirption  https://leetcode-cn.com/problems/next-permutation/
 * 下一个排列，根据给定的数字序列，获取字典序列的下一个排列。
 * 原地排列，只允许使用额外常数空间
 *
 * 重要的是思想，首先从右往左判断，是否存在i，满足num[i] > num[i-1];
 * 存在的话，重新从右往左判断，看是否有j，满足num[j] < num[i]；
 * 交换两者；
 * 反转i之后的所有的数
 * @Author yizhendong
 * @Date 2019/6/2
 **/
@Medium
@TriedButFaild
public class Solution31 {
    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        if (i>=0){
            int j = nums.length - 1;
            while (j>=0&& nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while ( i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
