package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Solution90 {
    /**
     * 还是回溯法的经典题型
     */
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, 0);
        return res;
    }

    public void backtrack(int[] nums, boolean[] visited, int start){
        res.add(new ArrayList(track));
        for(int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, i + 1);
            visited[i] = false;
            track.removeLast();
        }
    }
}
