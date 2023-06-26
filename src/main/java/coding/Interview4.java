package coding;

// 二维数组的查询
// 其中从左到右依次增大
// 从上到下依次增大
public class Interview4 {
    // 我自己用的是二维数组来计算，但是看了剑指offer之后，发现其实可以用一维数组来计算，而且看起来还很简洁
    public static boolean found (int[] matrix, int rows, int columns, int target){
        // 1.Check the validation of parameter.
        if (rows <= 0 || columns <= 0 || matrix == null || matrix.length == 0){
            return false;
        }

        // 2.try to search the target number.
        int row = 0;
        int column = columns - 1;
        while (row < rows && column > 0){
            if (matrix[row * columns + column] == target) {
                return true;
            } else if (matrix[row * columns + column] > target){
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
