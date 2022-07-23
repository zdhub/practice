package coding_interviews;

import leetcode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * There are n arrays. A permutation is generated when an element is selected from each array.
 * How do you generate all permutations of n arrays?
 * For example, permutations for the 3 arrays {1, 2}, {3, 4}, {5, 6} are: {1, 3, 5}, {1, 3, 6}, {1, 4, 5}, {1, 4, 6}, {2, 3, 5},
 * {2, 3, 6}, {2, 4, 5}, and {2, 4, 6}.
 * @Comment 这也是一个排列组合的题，这次用到了递归；同时也用到了栈；
 * @Tag: backtrack; stack; permutation;
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/23
 * @Time:11:40
 */

@Medium
public class Interview67 {
    public List<List<Integer>> GetPermutations (List<List<Integer>> arrays){
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        permute(result, linkedList, arrays);
        return result;
    }
    public void permute(List<List<Integer>> result, LinkedList<Integer> linkedList, List<List<Integer>> arrays){
        if (linkedList.size() == arrays.size()){
            result.add(new ArrayList<>(linkedList));
            return;
        }
        List<Integer> list = arrays.get(linkedList.size());
        for (int i = 0; i < list.size(); i ++ ){
            linkedList.push(list.get(i));
            permute(result, linkedList, arrays);
            linkedList.pop();
        }
        return;
    }

    public static void main(String[] args) {
        Interview67 interview67 = new Interview67();
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(2);
        List<Integer> array2 = new ArrayList<>();
        array2.add(3);
        array2.add(4);
        arrays.add(array1);
        arrays.add(array2);
        List<List<Integer>> result = interview67.GetPermutations(arrays);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("=================");
        }
    }
}
