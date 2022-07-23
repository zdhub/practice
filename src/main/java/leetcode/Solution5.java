package leetcode;

/**
 * @ClassName Solution5
 * @Descirption 最大回文数 中心扩展算法是一个时间复杂度较低的算法，O（N2），还有一种算法，Manacher 算法，复杂度为 O(n)
 * @Author yizhendong
 * @Date 7/2/2020
 **/
@Medium
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("qweewq"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
