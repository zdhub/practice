package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * You may return the answer in any order.
 * @Comment: 和IntegerView 68是同一类，可以详见那个解释
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/23
 * @Time:14:18
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinationCore(result, new LinkedList<>(), 1, n, k);
        return result;
    }

    public void combinationCore(List<List<Integer>> result, LinkedList<Integer> sublist, int i, int n, int k){
        if(k == 0){
            result.add(new ArrayList<>(sublist));
            return;
        }

        // 注意这里的边界条件
        for(int j = i; j <= n; j++){
            sublist.push(j);
            combinationCore(result, sublist, j + 1, n, k-1);
            sublist.pop();
        }
    }

    // 第二种解法
    public List<List<Integer>> combineV2(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        // base case, initialize empty list
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        // Case I: Add number n to answer
        result = combineV2(n - 1, k - 1);
        for (List<Integer> list : result) {
            // add n to final result
            list.add(n);
        }

        // Case II: Do not add number n to answer
        result.addAll(combineV2(n - 1, k));
        return result;
    }
}
