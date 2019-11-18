package leetcode;

/**
 * @Description:滑动窗口最大值。给定一个数组nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的k个数字。滑动窗口每次只向右移动一位。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/19 0:13
 */
public class Solution239 {
    public static void main(String[] args) {

    }

    /**
     * 这是我首先想到的笨方法，时间复杂度为O(NK);空间复杂度为O(N-k+1)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length == 0) return nums;
        int[] result = new int[nums.length - k + 1];
        for(int i = 0;i<nums.length - k + 1;i++){
            int temp = nums[i];
            for(int j = i;j<i+k;j++){
                if(nums[j] > temp){
                    temp = nums[j];
                }
            }
            result[i] = temp;
        }
        return result;
    }
}
