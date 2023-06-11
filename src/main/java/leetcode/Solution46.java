package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

    // 在2023年的6月11日，看了拉不拉东的算法解释，目前有一些些思路
    // 核心的代码框架是这样的
    /**
     * result = []
     * <p>
     * def backtrack(路径，选择列表){
     * if 满足结束条件:
     * result.add(路径)
     * return
     * <p>
     * for 选择 in 选择列表:{
     * 做选择
     * backtrack(路径，选择列表)
     * 撤销选择
     * }
     * }
     */

    // 回到这个问题，可以不用n来解答
    List<List<Integer>> resultV2 = new ArrayList<>();

    public List<List<Integer>> permute2(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrackV2(track, visited, nums);
        return resultV2;
    }

    public void backtrackV2(LinkedList track, boolean[] visited, int[] nums){
        // 判断结束条件
        if (track.size() == nums.length){
            resultV2.add(new ArrayList<>(track));
            return;
        }

        // 选择列表
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }

            // 全排列的时候，才需要使用到Visited用来判断是否访问过
            visited[i] = true;
            track.add(nums[i]);
            backtrackV2(track, visited, nums);
            track.removeLast();
            visited[i] = false;
        }
    }
}
