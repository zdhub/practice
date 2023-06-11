package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: N Queen problem。需要用回溯法解决，第一次思考没有想到解决方法
 * 本质上还是回溯法，有了拉不拉东的算法框架，看起来就比较容易解决了
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/21
 * @Time:23:29
 */
@Hard
public class Solution51 {
    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> result = solution51.solveNQueensV2(8);
        System.out.println(result.size());
//        for (int i = 0; i < result.size(); i++) {
//            for (int j = 0; j < result.get(i).size(); j++) {
//                System.out.println(result.get(i).get(j));
//            }
//        }

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results  = new ArrayList<>();
        if (n <= 0){
            return results;
        }
        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    public void search(List<List<String>> results, List<Integer> cols, int n){
        if (cols.size() == n) {
            results.add(Draw(cols));
            return;
        }
        for(int i = 0; i < n; i++){
            if(!Valid(cols, i)){
                continue;
            }
            cols.add(i);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    public boolean Valid(List<Integer> cols, int col){
        int row = cols.size();
        for(int rowIndex = 0; rowIndex < cols.size(); rowIndex++){
            if (cols.get(rowIndex) == col){
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == col + row){
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - col){
                return false;
            }
        }
        return true;
    }

    public List<String> Draw(List<Integer> cols){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.size(); j++){
                if(i == cols.get(j)){
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }


    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueensV2(int n) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] array = new int[n];
        for(int i = 0; i < n;i++){
            array[i] = i;
        }
        backtrack(track, visited, array);
        return result;
    }

    public List<String> draw(List<Integer> list){
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < list.get(i); j++){
                sb.append(".");
            }
            sb.append("Q");
            for(int j = list.get(i) + 1; j < list.size(); j++){
                sb.append(".");
            }
            temp.add(sb.toString());
        }
        return temp;
    }

    public void backtrack(LinkedList<Integer> track, boolean[] visited, int[] array){
        if(track.size() == array.length){
            if (valid(track)){
                result.add(draw(track));
                return;
            }
        }
        for(int i = 0; i < array.length; i++){
            if(visited[i]){
                continue;
            }
            track.add(i);
            visited[i] = true;
            backtrack(track, visited, array);
            visited[i] = false;
            track.removeLast();
        }
    }

    public boolean valid(LinkedList<Integer> track){
        for(int i = 0; i < track.size(); i++){
            for(int j = i +1 ;j < track.size();j++){
                if (track.get(i) - track.get(j) == i -j ){
                    return false;
                }
                if (track.get(i) - track.get(j) == j - i ){
                    return false;
                }
            }
        }
        return true;
    }
}
