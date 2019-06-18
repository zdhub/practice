package leetcode;

/**
 * @ClassName Solution11
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
