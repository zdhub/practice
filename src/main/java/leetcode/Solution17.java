package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution17
 * @Descirption 电话号码的字母组合 medium  有点难度，第一次没搞出来
 * @Author yizhendong
 * @Date 2019/5/12
 **/
@Medium
public class Solution17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("322"));
        return;
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        hashMap.put("2", Arrays.asList("a", "b", "c"));
        hashMap.put("3", Arrays.asList("d", "e", "f"));
        hashMap.put("4", Arrays.asList("g", "h", "i"));
        hashMap.put("5", Arrays.asList("j", "k", "l"));
        hashMap.put("6", Arrays.asList("m", "n", "o"));
        hashMap.put("7", Arrays.asList("p", "q", "r", "s"));
        hashMap.put("8", Arrays.asList("t", "u", "v"));
        hashMap.put("9", Arrays.asList("w", "x", "y", "z"));
        return getLetter(digits, hashMap);
    }

    private static List<String> getLetter(String digits, HashMap<String, List<String>> hashMap) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        int i = 0;
        String pre = "";
        String item = digits.substring(i, i + 1);
        List<String> list = hashMap.get(item);
        getLetterFromIndex(pre, list, i + 1, result, digits, hashMap);
        return result;
    }

    private static void getLetterFromIndex(String pre, List<String> list, int num, List<String> result, String digits, HashMap<String, List<String>> hashMap) {
        if (num >= digits.length()) {
            for (int i = 0; i < list.size(); i++) {
                result.add(pre + list.get(i));
            }
            return;
        }
        List<String> newList = hashMap.get(digits.substring(num, num + 1));
        for (int i = 0; i < list.size(); i++) {
            getLetterFromIndex(pre + list.get(i), newList, num + 1, result, digits, hashMap);
        }
    }
}
