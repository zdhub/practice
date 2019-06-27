package leetcode;

import java.util.*;

/**
 * @Description:字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/27 22:58
 */
@Medium
public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = {"", ""};
        System.out.println(solution49.groupAnagrams(strs));
    }

    /**
     * 我的方法，可以处理，但是没有找到比较快的key-value映射关系，所以只能每个char的比较，时间复杂度比较高
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (result.size() == 0) {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
            } else {
                List<List<String>> resultTemp = new ArrayList<>(result);
                boolean added = false;
                for (int j = 0; j < resultTemp.size(); j++) {
                    List<String> list = result.get(j);
                    List<String> tempList = new ArrayList<>(list);
                    String item = tempList.get(0);
                    if (item.length() != str.length()) {
                        continue;
                    }
                    if (item.equals(str)) {
                        list.add(str);
                        added = true;
                        break;
                    }
                    char[] chItem = item.toCharArray();
                    char[] chStr = str.toCharArray();
                    Arrays.sort(chItem);
                    Arrays.sort(chStr);
                    for (int k = 0; k < chItem.length; k++) {
                        if (chItem[k] != chStr[k]) {
                            break;
                        }
                        if (k == chItem.length - 1) {
                            added = true;
                            list.add(str);
                        }
                    }
                }
                if (!added) {
                    List<String> addList = new ArrayList<>();
                    addList.add(str);
                    result.add(addList);
                }
            }
        }
        return result;
    }

    /**
     * leetcode官方第一个中解法，相对来说比较容易理解，key-value中的key为string中的char的顺序排列后的string
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    /**
     * leetcode官方第二个种解法，相对来说比较容易理解，key-value中的key为用＃字符分隔的字符，例如 abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
