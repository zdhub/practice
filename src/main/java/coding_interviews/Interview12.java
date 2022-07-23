package coding_interviews;

public class Interview12 {
    public boolean hasPath(char[] metrics, int rows, int columns, String strs){
        // 1.valid the parameter

        // 2.the core contains path logic
        int pathLength = 0;
        boolean[] visited = new boolean[metrics.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (hasPathCore(metrics, rows, columns, i, j, strs, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] metrics, int rows, int columns, int row, int column, String strs, int pathLength, boolean[] visited){
        if(pathLength == strs.length()) {
            return true;
        }
        if (row > rows || column > columns) {
            return false;
        }

        if (strs.charAt(pathLength) == metrics[row * rows + column] && !visited[row * rows + column]){
            visited[row * rows + column] = true;
            if(hasPathCore(metrics, rows, columns, row, column + 1, strs, pathLength + 1, visited)||
                    hasPathCore(metrics, rows, columns, row, column - 1, strs, pathLength + 1, visited)||
                    hasPathCore(metrics, rows, columns, row - 1, column, strs, pathLength + 1, visited)||
                    hasPathCore(metrics, rows, columns, row + 1, column, strs, pathLength + 1, visited)){
                return true;
            } else {
                visited[row * rows + column] = false;
            }
        }
        return false;
    }
}
