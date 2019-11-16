package leetcode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: 第一次没有做出来
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/16 13:28
 */

/**
 s = "3[a]2[bc]", 返回 "aaabcbc".
 s = "3[a2[c]]", 返回 "accaccacc".
 s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
@Medium
public class Solution394 {
    public static void main(String[] args) {
        String s ="3[a2[c]]";
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString(s));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0;i<cur_multi;i++) temp.append(res);
                res = new StringBuilder(stack_res.removeLast() + temp);
            } else if (c >= '0' && c <= '9') multi = multi * 10 + (c - '0');
            else res.append(c);
        }
        return res.toString();
    }
}
