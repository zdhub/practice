package leetcode;

/**
 * @Description:给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/12 0:30
 */
@Hard
public class Solution85 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Solution85 solution85 = new Solution85();
        System.out.println(solution85.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int[][] heights = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] - '0';
                } else {
                    heights[i][j] = matrix[i][j] -'0' == 0 ? 0 : (heights[i - 1][j] + 1);
                }
            }
            max = Math.max(max, getMaxArea(heights, i));
        }
        return max;
    }

    private int getMaxArea(int[][] heights, int i) {
        int[] height = new int[heights[i].length];
        for (int j = 0; j < heights[i].length; j++) {
            height[j] = heights[i][j];
        }
        return getSingleLineArea(height, 0, height.length - 1);
    }

    private int getSingleLineArea(int[] height, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (height[i] < height[minIndex]) {
                minIndex = i;
            }
        }
        return Math.max(Math.max(getSingleLineArea(height, start, minIndex - 1), getSingleLineArea(height, minIndex + 1, end)), (end - start + 1) * height[minIndex]);
    }
}
