package leetcode;

/**
 * @ClassName Solution13
 * @Descirption easy难度 罗马数字转整数，https://leetcode-cn.com/problems/roman-to-integer/
 * @Author yizhendong
 * @Date 2019/5/12
 **/
@Easy
public class Solution13 {
    public static int romanToInt(String roman) {
        int result = 0;
        if (roman == null || roman.length() == 0) return result;
        while (roman.startsWith("M")){
            result = result + 1000;
            roman = roman.substring(1);
            if (roman == null || roman.length() == 0) return result;
        }

        if (roman.startsWith("CM")){
            result = result + 900;
            roman = roman.substring(2);
            if (roman == null || roman.length() == 0) return result;
        }
        while (roman.startsWith("D")){
            result = result + 500;
            roman = roman.substring(1);
            if (roman == null || roman.length() == 0) return result;
        }
        if (roman.startsWith("CD")){
            result = result + 400;
            roman = roman.substring(2);
            if (roman == null || roman.length() == 0) return result;
        }
        while (roman.startsWith("C")){
            result = result + 100;
            roman = roman.substring(1);
            if (roman == null || roman.length() == 0) return result;
        }
        if (roman.startsWith("XC")){
            result = result + 90;
            roman = roman.substring(2);
            if (roman == null || roman.length() == 0) return result;
        }

        while (roman.startsWith("L")){
            result = result + 50;
            roman = roman.substring(1);
            if (roman == null || roman.length() == 0) return result;
        }
        if (roman.startsWith("XL")){
            result = result + 40;
            roman = roman.substring(2);
            if (roman == null || roman.length() == 0) return result;
        }
        while (roman.startsWith("X")){
            result = result + 10;
            roman = roman.substring(1);
            if (roman == null || roman.length() == 0) return result;
        }
        if (roman.startsWith("IX")){
            result = result + 9;
            roman = roman.substring(2);
            if (roman == null || roman.length() == 0) return result;
        }
        while (roman.startsWith("V")){
            result = result + 5;
            roman = roman.substring(1);
            if (roman == null || roman.length() == 0) return result;
        }
        if (roman.startsWith("IV")){
            result = result + 4;
            roman = roman.substring(2);
            if (roman == null || roman.length() == 0) return result;
        }
        while (roman.startsWith("I")){
            result = result + 1;
            roman = roman.substring(1);
            if (roman == null || roman.length() == 0) return result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
