package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:全排列2 https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 和46相比，给定的数组中可能含有相同的数字
 * 回溯法，依然不是很懂
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/26 23:25
 */
@Medium
@TriedButFaild
public class Solution47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = solution47.permuteUnique(nums);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println("   ");
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
