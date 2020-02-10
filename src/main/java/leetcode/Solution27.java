package leetcode;

import java.util.Arrays;

/**
 * @ClassName Solution27
 * @Descirption 移除元素，也可以使用双指针方法
 * @Author yizhendong
 * @Date 2019/5/26
 **/
@Easy
public class Solution27 {
    public static void main(String[] args) {
        int[] result = {0, 0, 0, 1, 1, 1, 2, 3, 4};
        int num = removeElement(result, 1);
        System.out.println(num);
        Arrays.stream(result).forEach(item -> System.out.println(item));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int i = 0;
        while (i < nums.length - result) {
            if (nums[i] == val) {
                transfer(nums, i);
                result++;
                continue;
            }
            i++;
        }
        return nums.length - result;
    }

    private static void transfer(int[] nums, int i) {
        int k = i;
        while (k < nums.length - 1) {
            int temp = nums[k];
            nums[k] = nums[k + 1];
            nums[k + 1] = temp;
            k++;
        }
    }

    /**
     * 双指针方法
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
