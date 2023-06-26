package coding;

import leetcode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: Please generate all combinations of a given string. For example, combinations of a given string
 * “abc” are “a”, “b”, “c”, “ab”, “ac”, “bc”, and “abc”.
 * @Comment: 第一次也不是很懂，需要重复练习。关于排列组合的题目，目前还不是很熟练; 和Leetcode 77 是同一个类型的题
 * @Tag: combinations; backtracking;
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/23
 * @Time:13:22
 */
@Medium
public class Interview68 {
    public static void main(String[] args) {
        String str = "abcd";
        Interview68 interview68 = new Interview68();
        List<List<Character>> result = interview68.combinations(str);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("==========");
        }
    }
    public List<List<Character>> combinations(String str){
        List<List<Character>> result = new ArrayList<>();
        LinkedList<Character> subList = new LinkedList<>();
        // 首先，因为需要获取所有的组合，从长度为1到长度为全长，所以需要循环
        for (int i = 1; i <= str.length(); i++) {
            combinationCoreV2(str, 0, i, result, subList);
        }
        return result;
    }

    // 这是第二种方法，也是使用了回溯法。回溯法的特点就是进行递归，同时被递归的函数的前后分别插入一个元素，以及再弹出这个元素。这个解法的回溯代码段被循环包裹。
    private void combinationCoreV2(String str, int index, int number, List<List<Character>> result, LinkedList<Character> subList) {
        if (number == 0){
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = index; i <= str.length() - number; i ++ ){
            subList.push(str.charAt(i));
            combinationCoreV2(str, i + 1, number -1, result, subList);
            subList.pop();
        }
    }

    // 这是第一种方法，本质也是回溯法，只不过并没有循环，而是在回溯代码的整体的下方加上了另外一个回溯。
    private void combinationCore(String str, int index, int number, List<List<Character>> result, LinkedList<Character> subList) {
        if (number == 0){
            result.add(new ArrayList<>(subList));
            return;
        }
        if (index == str.length()){
            return;
        }

        // Select the character str[index]
        subList.push(str.charAt(index));
        combinationCore(str, index + 1, number - 1, result, subList);
        subList.pop();

        // Skip the character str[index]
        combinationCore(str, index + 1, number, result, subList);
    }
}
