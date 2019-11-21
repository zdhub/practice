package leetcode;

/**
 * @Description:跳跃游戏 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/20 23:06
 */
public class Solution55 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1, 2, 0, 2};
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump2(num));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        boolean[] temp = new boolean[nums.length];
        temp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int len = nums[i];
            for (int j = 1; j <= len; j++) {
                if (i + j >= nums.length) break;
                temp[i + j] = true;
            }
            if (temp[i] == false) return false;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == false) return false;
        }
        return true;
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int lastJum = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastJum) {
                lastJum = i;
            }
        }
        return lastJum == 0;
    }
}
