package leetcode;

import java.util.HashMap;

/**
 * @Description:有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
 * 第一次没有想到如何将小九宫格和坐标系对应
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/19 23:47
 */
public class Solution36 {
    public static void main(String[] args) {

    }
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer> rows[] = new HashMap[9];
        HashMap<Integer, Integer> columns[] = new HashMap[9];
        HashMap<Integer, Integer> boxes[] = new HashMap[9];
        for (int i = 0;i<9;i++){
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0;i<9;i++){
            for (int j = 0;j<9;j++){
                char num = board[i][j];
                if (num != '.'){
                    int n = num;
                    int box = (i/3)*3 + j/3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box].put(n, boxes[box].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) >1 || columns[j].get(n) > 1 || boxes[box].get(n) > 1) return false;
                }
            }
        }
        return true;
    }
}
