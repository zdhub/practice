package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针输出矩阵
 * 虽然我相出了一种方法：spiralOrderV1，但是这种方法有点长，需要精简
 * 参考Leetcode评论区的第一种解法spiralOrderV2
 */
public class Solution54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        Solution54 solution54 = new Solution54();
        List list = solution54.spiralOrderV1(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 这种方法简洁又易懂，只有20行代码，非常适合面试
    public List<Integer> spiralOrderV2(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        while (res.size() < n * m) {
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);

            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);

            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);

            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            left++; right--; up++; down--;
        }
        return res;
    }


    public List<Integer> spiralOrderV1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visitedMatrix = new boolean[matrix.length + 2][matrix[0].length + 2];
        if(matrix == null) return list;
        for(int i = 0; i < visitedMatrix.length; i++ ){
            visitedMatrix[i][0] = true;
            visitedMatrix[i][visitedMatrix[0].length - 1] = true;
        }
        for(int j = 0; j < visitedMatrix[0].length; j++ ){
            visitedMatrix[0][j] = true;
            visitedMatrix[visitedMatrix.length - 1][j] = true;
        }

        int i = 0;
        int j = 0;
        visitedMatrix[1][1] = true;
        boolean GetToEnd = false;
        int direction = 1;
        while(!GetToEnd){
            visitedMatrix[i+1][j+1] = true;
            list.add(matrix[i][j]);
            if(visitedMatrix[i+1][j+2] == true && visitedMatrix[i+2][j+1] == true &&
                    visitedMatrix[i+1][j] == true && visitedMatrix[i][j+1] == true){
                GetToEnd = true;
                break;
            }
            if(direction == 1){
                if(visitedMatrix[i+1][j+2] == false){
                    direction = 1;
                    j += 1;
                    continue;
                }
                if(visitedMatrix[i+2][j+1] == false){
                    direction = 2;
                    i += 1;
                    continue;
                }
            }
            if(direction == 2){
                if(visitedMatrix[i+2][j+1] == false){
                    direction = 2;
                    i += 1;
                    continue;
                }
                if(visitedMatrix[i+1][j] == false){
                    direction = 3;
                    j -= 1;
                    continue;
                }
            }
            if(direction == 3){
                if(visitedMatrix[i+1][j] == false){
                    direction = 3;
                    j -= 1;
                    continue;
                }
                if(visitedMatrix[i][j+1] == false){
                    direction = 4;
                    i -= 1;
                    continue;
                }
            }
            if(direction == 4){
                if(visitedMatrix[i][j+1] == false){
                    direction = 4;
                    i -= 1;
                    continue;
                }
                if(visitedMatrix[i+1][j+2] == false){
                    direction = 1;
                    j += 1;
                    continue;
                }
            }
            GetToEnd = true;
        }
        return list;
    }

}
