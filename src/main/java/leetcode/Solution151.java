package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: Reverse Words in a String。 For instance, the reversed output should be “student. a am I” when
 * the input is “I am a student.”
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/20
 * @Time:16:59
 * @Comment: 这个题和剑指Offer英文版第91题是一样的。这个题如果用Java内置的方法来处理的话，可以很简单，简单到只需要三行代码。
 */
@Medium
public class Solution151 {
    public String reverseString(String sentence){
        // " +"是一个正则表达式，代表一个或者多个空格。
        String[] words = sentence.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }

    // 这种方式完全不用java中的trim，split以及string builder直接用指针进行操作。
    public String reverseStringV2(String sentence){
        char[] chars = sentence.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);
        reverseWords(chars, n);
        return cleanSpace(chars, n);
    }

    private String cleanSpace(char[] chars, int length) {
        int i = 0, j = 0;
        while (j < length){
            while (j < length && chars[j] == ' ') j++;
            while (j < length && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < length && chars[j] == ' ') j++;
            if (j < length) chars[i++] = ' '; // keep only one space
        }
        return new String(chars).substring(0, i);
    }

    private void reverseWords(char[] chars, int length) {
        int i = 0, j = 0;
        while (i < length){
            while (i < j || i < length && chars[i] == ' ') i++; // skip space
            while (j < i || j < length && chars[j] != ' ') j++; // skip no space
            reverse(chars, i, j - 1); // reverse words
        }
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseString(str));
        System.out.println(solution151.reverseStringV2(str));
    }
}
