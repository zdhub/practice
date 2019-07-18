package leetcode;

/**
 * @Description:通配符匹配 https://leetcode-cn.com/problems/wildcard-matching/
 * 没有一点思路。
 * 第一种解法：使用双指针，分别代表string和pattern循环的id，当pattern和str循环处字符一致是第一种情况；
 * 当pattern为'*'是第二种情况，当startidx不为-1（即结束了"*"匹配时是第三种情况），其他的返回false。
 * <p>
 * 第二种解法：使用动态规划
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/24 21:32
 */
@Hard
public class Solution44 {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.isMatch("abcdeft", "*"));
        System.out.println(solution44.isMatch("abcdeft", "a*f?"));
        System.out.println(solution44.isMatch("abcdeft", "a*?t"));
        System.out.println(solution44.isMatch("abcdeft", "a*f?h"));
    }

    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, startIdx = -1, match = 0;
        while (s < str.length()) {
            //第一种情况，str和pattern正常推进
            if (p < pattern.length() && (pattern.charAt(p) == str.charAt(s) || pattern.charAt(p) == '?')) {
                p++;
                s++;
                //第二种情况，来到了"*"
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                startIdx = p;
                match = s;
                p++;
                //第三种情况，pattern迭代到"*"之后
            } else if (startIdx != -1) {
                p = startIdx + 1;
                match++;
                s = match;
                //最后一种返回为false
            } else return false;
        }
        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }
        return p == pattern.length();
    }

    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];

    }
}
