package leetcode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:组合总和 https://leetcode-cn.com/problems/combination-sum/  candidates 中的数字可以无限制重复被选取。
 * 无重复元素的数组
 * 数字可以无限制重复被选取
 * <p>
 * 又是回溯法！
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/22 16:08
 */
@Medium
@TriedButFaild
public class Solution39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        Solution39 solution39 = new Solution39();
        List<List<Integer>> result = solution39.combinationSum(candidates, 7);
        if (!CollectionUtils.isEmpty(result)){
            for (int i = 0;i<result.size();i++){
                List<Integer> list = result.get(i);
                for (int j = 0;j<list.size();j++){
                    System.out.println(list.get(j));
                }
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] > target) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list=new ArrayList<Integer>();
//        getResult(candidates, 0, result, new ArrayList<Integer>(), target);
        find(result, list, candidates, target, 0);
        return result;
    }

//    private void getResult(int[] candidates, int num, List<List<Integer>> result, List<Integer> integers, int target) {
//        if (target == 0){
//            result.add(integers);
//            return;
//        }
//        if (candidates[0] > target) return;
//
//        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
//            //拷贝一份，不影响下次递归
//            List<Integer> list=new ArrayList<>(integers);
//            list.add(candidates[i]);
//            //递归运算，将i传递至下一次运算是为了避免结果重复。
//            getResult(candidates,i,result,list,target - candidates[i]);
//        }
//    }

    public void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        }
        if(target<candidates[0]) return;
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
            //拷贝一份，不影响下次递归
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }
    }
}
