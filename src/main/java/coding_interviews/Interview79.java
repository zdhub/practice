package coding_interviews;

import leetcode.Easy;

import java.util.HashSet;

/**
 * @Description: Please implement a function to delete all duplicated characters in a string and keep only the
 * first occurrence of each character left. For example, if the input is string “google”, the result after deletion is
 * “gole”
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/7
 * @Time:17:47
 */
@Easy
public class Interview79 {
    public String DeleteDuplication(String str){
        if (str == null || str.length() == 0){
            return str;
        }
        HashSet<Character> charSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (charSet.contains(str.charAt(i))){
                continue;
            }
            charSet.add(str.charAt(i));
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Interview79 interview79 = new Interview79();
        System.out.println(interview79.DeleteDuplication("google"));
    }
}
