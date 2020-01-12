package leetcode;

/**
 * @Description:矩阵中的最长递增路径
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/12 20:02
 */
@Hard
public class Solution329 {
    private int[] row = {-1, 1, 0, 0};
    private int[] col = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] lengthMap = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int maxValue = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxValue = Math.max(getLength(matrix, lengthMap, visited, i, j), maxValue);
            }
        }
        return maxValue;
    }

    /**
     * 动态规划，使用两个存储的map，一个代表是否请求过，另一个代表这个坐标的长度值
     * @param matrix
     * @param lengthMap
     * @param visited
     * @param x
     * @param y
     * @return
     */
    public int getLength(int[][] matrix, int[][] lengthMap, boolean[][] visited, int x, int y) {
        if (visited[x][y]) {
            return lengthMap[x][y];
        }
        lengthMap[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int curX = x + row[i];
            int curY = y + col[i];
            if (curX >= 0 && curX < matrix.length && curY >= 0 && curY < matrix[0].length && matrix[curX][curY] < matrix[x][y]) {
                lengthMap[x][y] = Math.max(lengthMap[x][y], getLength(matrix, lengthMap, visited, curX, curY) + 1);
            }
        }
        visited[x][y] = true;
        return lengthMap[x][y];
    }
}