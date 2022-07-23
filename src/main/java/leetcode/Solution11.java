package leetcode;

/**
 * @ClassName Solution11 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @Descirption
 * @Author yizhendong
 * @Date 2019/4/1
 **/
public class Solution11 {
    public static int maxArea(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int left = 0, right = height.length - 1, result = 0;
        while(left < right){
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }

}
