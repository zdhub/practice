package coding_interviews;

import leetcode.Easy;

import java.util.HashSet;

/**
 * @Description:Given two strings, how do you delete characters contained in the second string from the first
 * string? For example, if all characters in the string “aeiou” are deleted from the string “We are students.”, the
 * result is “W r stdnts.”.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/7
 * @Time:17:37
 */
@Easy
public class Interview78 {
    public String DeleteCharacters(String s1, String s2){
        HashSet<Character> charSet = new HashSet<>();
        charSet = GetUniqCharSet(s2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (charSet.contains(s1.charAt(i))){
                continue;
            }
            sb.append(s1.charAt(i));
        }
        return sb.toString();
    }

    public static HashSet<Character> GetUniqCharSet(String str){
        HashSet<Character> charSet = new HashSet<>();
        if (str == null || str.length() == 0){
            return charSet;
        }
        for (int i = 0; i < str.length(); i++) {
            charSet.add(str.charAt(i));
        }
        return charSet;
    }

    public static void main(String[] args) {
        Interview78 interview78 = new Interview78();
        String result = interview78.DeleteCharacters("Hello World", "eo");
        System.out.println(result);
    }
}
