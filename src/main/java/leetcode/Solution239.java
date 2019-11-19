package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description:滑动窗口最大值。给定一个数组nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的k个数字。滑动窗口每次只向右移动一位。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/19 0:13
 */
public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution239 solution239 = new Solution239();
        Arrays.stream(solution239.maxSlidingWindow2(nums, 3)).forEach(System.out::println);
    }

    /**
     * 这是我首先想到的笨方法，时间复杂度为O(NK);空间复杂度为O(N-k+1)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int temp = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > temp) {
                    temp = nums[j];
                }
            }
            result[i] = temp;
        }
        return result;
    }

    /**
     * 时间复杂度较小的一种方法是使用双端队列
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k == 0 || nums.length == 0) return nums;
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for (int i = k - 1; i < nums.length; i++) {
            while (!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > k) {
                indexDeque.removeFirst();
            }
            result[i + 1 - k] = nums[indexDeque.getFirst()];
        }
        return result;
    }
}
