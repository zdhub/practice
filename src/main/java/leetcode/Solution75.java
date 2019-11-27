package leetcode;

import java.util.Arrays;

/**
 * @Description: 颜色分类，又叫做荷兰国旗问题
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/28 0:43
 */
public class Solution75 {
    public static void main(String[] args) {
        int[] num = {2,0,1};
        Solution75 solution75 = new Solution75();
        solution75.sortColors(num);
        Arrays.stream(num).forEach(System.out::print);
    }

    public void sortColors(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int curIndex = 0;
        while (curIndex <= rightIndex){
            if (nums[curIndex] == 0){
                swap(nums, leftIndex, curIndex);
                leftIndex++;
                curIndex++;
            } else if (nums[curIndex] == 2){
                swap(nums, curIndex, rightIndex);
                rightIndex --;
            } else {
                curIndex++;
            }
        }
    }

    private void swap(int[] nums, int leftIndex, int curIndex) {
        int temp = nums[leftIndex];
        nums[leftIndex] = nums[curIndex];
        nums[curIndex] = temp;
    }
}
