package leetcode;

/**
 * @ClassName Solution28
 * @Descirption  实现strStr()
 * @Author yizhendong
 * @Date 2019/5/26
 **/
@Easy
public class Solution28 {
    public static void main(String[] args) {
        System.out.println(strStr("baaaaa", "baaaaa"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;
        if (needle == "") return 0;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0;i<=haystack.length()-needle.length();i++){
            String s = haystack.substring(i);
            if (s.startsWith(needle)) return i;
        }
        return -1;
    }
}
