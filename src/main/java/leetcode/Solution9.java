package leetcode;

/**
 * @Description:回文数 判断一个整数是否是回文数。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/2/8 18:34
 */
@Easy
public class Solution9 {
    public boolean isPalindrome(int x) {
        String numStr = x + "";
        char[] chars = numStr.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(9119));
    }

}
