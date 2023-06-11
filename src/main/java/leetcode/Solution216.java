package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * Combination Sum III
 * 在找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 *
 * 也是回溯法的题型
 */
@Medium
public class Solution216 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] numbers = new int[9];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = i+1;
        }
        backtrack(numbers, k, n, 0);
        return res;
    }


    // 注意这里的start参数
    public void backtrack(int[] numbers,  int k, int target, int start){
        if(track.size() == k && target == 0 ) {
            res.add(new LinkedList(track));
            return;
        }
        if(track.size() > k || target < 0 ) {
            return;
        }
        for(int i = start; i < numbers.length; i++){
            track.add(numbers[i]);
            backtrack(numbers,  k, target - numbers[i], i + 1);
            track.removeLast();
        }
    }
}
