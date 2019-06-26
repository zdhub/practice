package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:全排列 https://leetcode-cn.com/problems/permutations/
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 * 没有思路。。。
 * 还是回溯法
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/25 23:26
 */
@Medium
public class Solution46 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer num : nums) {
            temp.add(num);
        }
        int n = nums.length;
        backtrack(n, result, temp, 0);
        return result;
    }

    private void backtrack(int n, List<List<Integer>> result, ArrayList<Integer> temp, int first) {
        if (first == n) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(temp, i, first);
            backtrack(n, result, temp, first + 1);
            Collections.swap(temp, first, i);
        }
    }
}
