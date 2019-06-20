package leetcode;

/**
 * @Description:解数独 https://leetcode-cn.com/problems/sudoku-solver/
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/20 22:14
 */
@Hard
public class Solution37 {
    //完全没有思路
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution37 solution = new Solution37();
        solution.printBoard(board);
        solution.solveSudoku(board);
        solution.printBoard(board);
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] column = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    column[j][num] = true;
                    int boxIndex = i / 3 * 3 + j / 3;
                    box[boxIndex][num] = true;
                }
            }
        }
        dfs(board, row, column, box, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] column, boolean[][] box, int i, int j) {
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            int boxIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !column[j][num] && !box[boxIndex][num]) {
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                column[j][num] = true;
                box[boxIndex][num] = true;
                if (dfs(board, row, column, box, i, j)) {
                    return true;
                } else {
                    row[i][num] = false;
                    column[j][num] = false;
                    box[boxIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}
