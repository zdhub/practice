package com.example.spring.practice;

import org.springframework.web.util.HtmlUtils;

/**
 * @ClassName Solution
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/28
 **/
public class Solution {
    public static String longestPalindrome(String str) {
        if(str == null || str.length() <= 1) return str;
        int mx = 0, id = 0;

        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < str.length(); i++) {
            newStr.append(str.charAt(i));
            newStr.append('#');
        }
        int[] Mp = new int[newStr.length()];
        for(int i = 1;i<newStr.length();i++){
            Mp[i] = mx > i? Math.min(Mp[2*id - i], mx - i):1;
            while(i+Mp[i] < newStr.length() && i - Mp[i] >= 0 && newStr.charAt(i+Mp[i]) - newStr.charAt(i-Mp[i]) == 0) Mp[i]++;
            if(i+Mp[i] > mx){
                mx = i + Mp[i];
                id = i;
            }
        }
        return newStr.substring(id - mx + id + 1, mx).replace("#", "");
    }

    public static String newLongestPalindrome(String string) {

        //-----------------------------------
        //转换字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            stringBuilder.append("#");
        }
        //-----------------------------------
        int rightIndex = 0;
        int centerIndex = 0;
        //求len中的最大
        int answer = 0;
        //answer最大时的中心
        int index = 0;
        int len[] = new int[stringBuilder.length() ];
        for (int i = 1; i < stringBuilder.length(); i++) {
            //当rightIndex > i，那么我们就在rightIndex - i 与len[2 * centerIndex - i](len[j])，取得最小值
            //因为当i + len[j] < rightIndex时，我们就把len[i]更新为len[j]
            //但是如果i + len[j] >= rightIndex时，我们暂且将len[i]定更新为rightIndex - i,超出的部分需要我们一个一个的匹配
            if (rightIndex > i) {
                len[i] = Math.min(rightIndex - i, len[2 * centerIndex - i]);
            } else {
                len[i] = 1;
            }
            //一个一个匹配
            //要么是超出的部分，要么是i > rightIndex
            while(i - len[i] >= 0 && i + len[i] < stringBuilder.length() && stringBuilder.charAt(i - len[i]) == stringBuilder.charAt(i + len[i])) {
                len[i]++;
            }
            //当 len[i] + i > rightIndex,我们需要更新centerIndex和rightIndex
            //至于为什么会这样做，理解一下rightIndex和centerIndex的含义
            if(len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                centerIndex = i;
            }
            if(len[i] > answer) {
                answer = len[i];
                index = i;
            }
        }
        //截取字符串
        //为什么index - answer + 1,因为len[i] - 1才是原来的回文字符串长度，而answer记录的是len中最大值
        return stringBuilder.substring(centerIndex - (rightIndex - centerIndex) , rightIndex).replace("#", "");
//        return stringBuilder.substring(index - answer + 1, index + answer).replace("#", "");
    }




    public static void main(String[] args) {
        String str = "\"";
        System.out.println(HtmlUtils.htmlEscape(str));
    }

}
