package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution6
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/31
 **/
public class Solution6 {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        StringBuilder sb = new StringBuilder();
        int curLen = 2 * numRows - 2;
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                for (int j = 0; j < (s.length() + curLen - 1) / curLen; j++) {
                    if (j * curLen < s.length()) {
                        sb.append(s.charAt(j * curLen));
                    }
                }
                System.out.println(1 + sb.toString());
            } else if (i == numRows) {
                for (int j = 0; j < (s.length() + curLen - 1) / curLen; j++) {
                    if (curLen * j + (numRows - 1) < s.length()) {
                        sb.append(s.charAt(curLen * j + (numRows - 1)));
                    }
                }
                System.out.println(2 + sb.toString());
            } else {
                for (int j = 0; j < (s.length() + curLen - 1) / curLen; j++) {
                    if (j * curLen + i - 1 < s.length() && j * curLen + i - 1 >= 0) {
                        sb.append(s.charAt(j * curLen + i - 1));
                    }
                    if ((j + 1) * curLen - i + 1 < s.length() && (j + 1) * curLen - i + 1 >= 0) {
                        sb.append(s.charAt((j + 1) * curLen - i + 1));
                    }
                }
                System.out.println(3 + sb.toString());
            }
        }
        return sb.toString();
    }

    //有一种写法很简单的算法
    public String convert1(String s, int rows) {
        if (rows <= 1) return s;
        if (s == null || s.length() <= rows) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.add(new StringBuilder());
        }
        //flag用来进行判断得到哪个StringBuilder；
        int i = 0;int flag = -1;
        for (Character c : s.toCharArray()){
            list.get(i).append(c);
            if (i == 0 || i == rows - 1) flag = flag * -1;
            i = i + flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : list){
            sb.append(row);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("123456789", 4));
        String str = "00123";
        System.out.println(Long.parseLong(str));
        int x = 13;
        String s = String.valueOf(13);
        char[] chars = s.toCharArray();
        System.out.println(s);
    }
}
