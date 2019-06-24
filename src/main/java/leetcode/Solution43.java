package leetcode;

/**
 * @Description:字符串相乘
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/24 20:56
 */
@Medium
public class Solution43 {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "4";
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.multiply(str1, str2));
    }

    public String multiply(String num1, String num2) {
        String[] result = new String[num1.length() + num2.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = "0";
        }
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if ("1".equals(num1)) return num2;
        if ("1".equals(num2)) return num1;
        int pre = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int first = Integer.parseInt(num1.substring(i, i + 1));
                int second = Integer.parseInt(num2.substring(j, j + 1));
                int smaller = (first * second + pre + Integer.parseInt(result[i + j + 1])) % 10;
                pre = (first * second + Integer.parseInt(result[i + j + 1]) + pre) / 10;
                result[i + j + 1] = smaller + "";
            }
            result[i] = pre+"";
            pre = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i].equals("0")) continue;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
