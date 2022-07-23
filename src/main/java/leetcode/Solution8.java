package leetcode;

/**
 * @ClassName Solution8
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/31
 **/
public class Solution8 {
    public static int myAtoi(String str) {
        if (str == null) return 0;
        if (str.length() <= 0) return 0;
        str = str.trim();
        if (str.length() <= 0) return 0;
        String temp = str;
        if (str.charAt(0) - '+' == 0 || str.charAt(0) - '-' == 0) {
            temp = str.substring(1);
        }
        if (temp.length() == 0) return 0;
        while (temp.charAt(0) - '0' == 0) {
            if (temp.length() == 1) return 0;
            temp = temp.substring(1);
        }
        for (int i = 0; i < temp.length(); i++) {
            if (i > 10) {
                temp = temp.substring(0, i);
                break;
            }
            if (temp.charAt(i) - '0' == 0 || temp.charAt(i) - '1' == 0 || temp.charAt(i) - '2' == 0 || temp.charAt(i) - '3' == 0 || temp.charAt(i) - '4' == 0 || temp.charAt(i) - '5' == 0 || temp.charAt(i) - '6' == 0 || temp.charAt(i) - '7' == 0 || temp.charAt(i) - '8' == 0 || temp.charAt(i) - '9' == 0) {
                continue;
            } else {
                temp = temp.substring(0, i);
                break;
            }
        }
        if (temp.length() <= 0) return 0;
        Long number = Long.parseLong(temp);
        if (str.charAt(0) - '-' == 0) {
            number = number * -1;
        }
        if (number < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return number.intValue();
    }

    public static int myAtoi2(String str) {
        char[] Chars = str.toCharArray();
        Character firstChar = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Chars.length; i++) {

            if (Chars[i] == '-' || Chars[i] == '+') {
                if (firstChar == null) {
                    firstChar = Chars[i];
                    sb.append(firstChar);
                } else {
                    break;
                }
            } else if (Chars[i] <= '9' && Chars[i] >= '0') {
                sb.append(Chars[i]);
            } else if (Chars[i] == ' ') {
                continue;
            } else break;
        }
        return convertStringToInteger(sb);
    }

    private static int convertStringToInteger(StringBuilder sb) {
        if (sb.length() == 0) return 0;
        if (sb.length() == 1) {
            if (sb.charAt(0) == '+' || sb.charAt(0) == '-') return 0;
        }
        long number = 0;
        int flag = sb.charAt(0) == '-' ? -1 : 1;
        String numberStr;
        if (sb.charAt(0) == '-' || sb.charAt(0) == '+') {
            numberStr = sb.substring(1);
        } else numberStr = sb.toString();

        for (int i = 0; i < numberStr.length(); i++) {

            Character num = numberStr.charAt(i);
            if (i == 0 && num == '0') return 0;
            number = number * 10 + num - '0';
            if (number * flag > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (number * flag < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) number * flag;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2(" "));
        System.out.println(myAtoi2(" "));
        System.out.println(myAtoi2("-1234"));
    }
}
