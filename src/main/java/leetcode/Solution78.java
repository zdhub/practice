package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 返回一个数组的子集
 */
@Medium
public class Solution78 {
    /**
     * 还是回溯法的经典题型
     */
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        res.add(new ArrayList(track));
        for(int i = start; i < nums.length; i++){
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
