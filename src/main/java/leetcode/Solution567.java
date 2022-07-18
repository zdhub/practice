package leetcode;

import java.util.*;

/**
 * @Description:
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/18
 * @Time:22:08
 */
public class Solution567 {
    public static void main(String[] args) {
        Solution567 s567 = new Solution567();
        System.out.println(s567.checkInclusion("ab", "eidbaooo"));
    }

    // 这是第一种方法，即暴力算法，时间复杂度为N的阶乘，效率太低
    public boolean checkInclusion(String s1, String s2){
        if (s2 == null || s2.length() < s1.length()) return false;
        int[] str1Array = new int[26];
        int[] str2Array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            str1Array[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            str2Array[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (str1Array[i] > str2Array[i]) return false;
        }
        List<String> strs = Permutation(s1);
        for (int i = 0; i < strs.size(); i++) {
            if(s2.contains(strs.get(i))) return true;
        }
        return false;
    }

    public List<String> Permutation(String nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length();
        StringBuilder sb = new StringBuilder(nums);
        backtrack(n, result, sb, 0);
        return result;
    }

    private void backtrack(int n, List<String> result, StringBuilder temp, int first) {
        if (first == n) {
            result.add(temp.toString());
        }
        for (int i = first; i < n; i++) {
            Swap(temp, i, first);
            backtrack(n, result, temp, first + 1);
            Swap(temp, first, i);
        }
    }

    private void Swap(StringBuilder sb, int i , int j){
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);
        sb.deleteCharAt(i);
        sb.insert(i, chj);
        sb.deleteCharAt(j);
        sb.insert(j, chi);
    }

    //还有第二种方法，可以通过Leetcode的test case，但是只排在倒数5%，效率也非常低，但是代码非常简单
    public boolean checkInclusionV2(String st1, String st2){
        st1 = sort(st1);
        for (int i = 0; i < st2.length() - st1.length(); i ++){
            if (st1.equals(sort(st2.substring(i, i + st1.length())))){
                return  true;
            }
        }
        return false;
    }
    public String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // 还有第三种方法，也是时间复杂度最低的一种方法
    // 利用滑动窗口来计算，滑动窗口基本是对比字符串的非常有效的一种解法
    // 这种解法中，需要维持一个count变量，用来代表两个相同长度的字符串中，相同的字符的数量，如果是26，则代表存在
    // 依次往右移动，每移动一个字符，则需要更新count值
    public boolean checkInclusionV3(String str1, String str2){
        if(str1.length() > str2.length()) return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            s1map[str1.charAt(i) - 'a'] ++;
            s2map[str2.charAt(i) - 'a'] ++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i]) count++;
        }

        for (int i = 0; i < str2.length() - str1.length(); i++) {
            int r = str2.charAt(i + str1.length()) - 'a';
            int l = str2.charAt(i) - 'a';
            if (count == 26) return true;
            s2map[r]++;
            if (s2map[r] == s1map[r]){
                count++;
            } else if (s2map[r] == s1map[r] + 1){
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]){
                count++;
            } else if (s2map[l] == s1map[l] - 1){
                count--;
            }
        }
        return count == 26;
    }


}
