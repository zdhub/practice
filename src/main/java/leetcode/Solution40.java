package leetcode;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Description: 组合总和 II  candidates 中的每个数字在每个组合中只能使用一次。  https://leetcode-cn.com/problems/combination-sum-ii/
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/23 15:46
 */
@Medium
public class Solution40 {
    private static HashSet<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        int[] candidates = {1, 1, 2, 5, 6, 7, 10};
        Solution40 solution39 = new Solution40();
        List<List<Integer>> result = solution39.combinationSum2(candidates, 8);
        if (!CollectionUtils.isEmpty(result)) {
            for (int i = 0; i < result.size(); i++) {
                List<Integer> list = result.get(i);
                for (int j = 0; j < list.size(); j++) {
                    System.out.println(list.get(j));
                }
                System.out.println("test");
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        getResult(candidates, target, result, list, 0);
        return result;
    }

    private void getResult(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int i) {
        if (target == 0) {
//            if (set.contains(list)) return;
            result.add(list);
            return;
        }
        if (target < candidates[0]) {
            return;
        }
        for (int j = i; j < candidates.length && target >= candidates[j]; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[j]);
            int k = j + 1;
            getResult(candidates, target - candidates[j], result, temp, k);
        }

    }


    /**
     * 标准的回溯法，需要注意的是backtrack的签名
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum2V2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, int start){
        if (target == 0){
            res.add(new ArrayList(track));
            return;
        }
        if (target < 0){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1);
            track.removeLast();
        }
    }
}
