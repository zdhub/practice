package leetcode;

import java.util.ArrayList;

/**
 * @Description:Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/1
 * @Time:23:56
 */
@Easy
public class Solution387 {
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        int[] charNum = new int[26];
        int countOverOnce = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length;i++){
            int index = chars[i] - 'a';
            charNum[index]++;
            if(charNum[index] == 2) {
                countOverOnce++;
            } else {
            }
            if(countOverOnce == 26) return -1;
        }
        for(int i = 0; i < chars.length;i++){
            int index = chars[i] - 'a';
            if(charNum[index] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution387 solution387 = new Solution387();
        System.out.println(solution387.firstUniqChar("itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb"));
    }
}
