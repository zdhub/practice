package coding;

public class Solution13 {
    public int movingCount(int threshold, int rows, int cols){
        boolean[] visited = new boolean[rows * cols];
        int count = coreMovingCount(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public int coreMovingCount(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)){
            visited[row * cols + col] = true;
            count = 1 + coreMovingCount(threshold, rows, cols, row, col + 1, visited) +
                    coreMovingCount(threshold, rows, cols, row, col - 1, visited) +
                    coreMovingCount(threshold, rows, cols, row + 1, col, visited) +
                    coreMovingCount(threshold, rows, cols, row - 1, col, visited);
        }
        return count;
    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row * cols + col] &&
        sumLessThenThreshold(threshold, col, row)){
            return true;
        }
        return false;
    }

    private boolean sumLessThenThreshold(int threshold, int col, int row) {
        int sum = getSum(col) + getSum(row);
        if (sum <= threshold) {
            return true;
        }
        return false;
    }

    public int getSum(int num){
        int result = 0;
        while (num > 0){
            result = result + num % 10;
            num = num/10;
        }
        return  result;
    }
}
