package leetcode;

/**
 * @Description:旋转图像 https://leetcode-cn.com/problems/rotate-image/submissions/
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/27 22:41
 */
@Medium
public class Solution48 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}};
        Solution48 solution48 = new Solution48();
        solution48.rotate(matrix);

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n / 2 - 1; j++) {
                swap(matrix, i, j, n - j - 1);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                swap2(matrix, i, j);
            }
        }
    }

    private void swap2(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][n - i - 1];
        matrix[n - j - 1][n - i - 1] = temp;
    }

    private void swap(int[][] matrix, int i, int j, int k) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][k];
        matrix[i][k] = temp;
    }
}
