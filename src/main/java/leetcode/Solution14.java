package leetcode;

/**
 * @ClassName Solution14
 * @Descirption easy 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 * @Author yizhendong
 * @Date 2019/5/12
 **/
@Easy
public class Solution14 {
    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null ||strs.length == 0) {
            return result;
        }
        String str = strs[0];
        if (str == null || str.length() == 0) return result;
        for (int i = 0; i < str.length();i++){
            Character c = str.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                String item = strs[j];
                if (item.length() <= i || item.length() == 0 || item.charAt(i) != c){
                    return result;
                }
            }
            result = result + str.charAt(i);
        }
        return strs[0];
    }
}
