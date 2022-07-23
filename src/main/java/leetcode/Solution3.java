package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName Solution3
 * @Descirption 不含有重复字符的 最长子串 的长度
 * 滑动窗口
 * @Author yizhendong
 * @Date 6/2/2020
 **/
@Medium
public class Solution3 {

    /**
     * 这种方法是可以，但是有更好的方法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int length = s.length();
        int[] longestStr = new int[length];
        String longestPreStr = "";
        for (int i = 0; i < length; i++) {
            if (length - i < longestPreStr.length()) break;
            String temp;
            if (longestStr[i] == 1 || longestStr[i] == 0){
                temp = s.substring(i, i+1);
            } else {
                temp = s.substring(i, i + longestStr[i]);
            }
            for (int k = i + temp.length(); k < length; k++) {
                char ch = s.charAt(k);
                if (!temp.contains(ch + "")) {
                    temp = temp + ch;
                    if (temp.length() > longestPreStr.length()){
                        longestPreStr = temp;
                    }
                } else {
                    int subLen = temp.length();
                    if (subLen > longestPreStr.length()) {
                        longestPreStr = temp;
                    }
                    int tempNum = subLen;
                    for (int j = i; j < i + tempNum; j++) {
                        longestStr[j] = subLen;
                        subLen--;
                    }
                    break;
                }
            }

        }
        return longestPreStr.length();
    }

    /**
     * 一种只需要进行O（N）时间复杂度的方法
     * @param s
     */
    public int lengthOfLongestSubstring1(String s){
        HashSet<Character> hashSet = new HashSet<>();
        int n = 0, i = 0, j = 0;
        int length = s.length();
        while (i < length && j <length){
            if (!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j++));
                n = Math.max(j - i, n);
            } else {
                //移除前面的值，直到不包含
                hashSet.remove(s.charAt(i++));
            }
        }
        return n;
    }

    /**
     * 还有一种方法，和上面的方法相比，也只需要遍历一次，但是比上边的方法减少了一半的时间
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring2("gabcbefg"));
    }
}
