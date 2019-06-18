package leetcode;

/**
 * @ClassName Solution8
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/31
 **/
public class Solution8 {
    public static int myAtoi(String str){
        if (str == null) return 0;
        if(str.length() <= 0) return 0;
        str = str.trim();
        if(str.length() <= 0) return 0;
        String temp = str;
        if(str.charAt(0) - '+' == 0 || str.charAt(0) - '-' == 0){
            temp = str.substring(1);
        }
        if(temp.length() == 0) return 0;
        while(temp.charAt(0) - '0' == 0){
            if (temp.length() == 1) return 0;
            temp = temp.substring(1);
        }
        for (int i = 0;i<temp.length();i++){
            if(i > 10) {
                temp = temp.substring(0, i);
                break;
            }
            if (temp.charAt(i) - '0' == 0 ||
                    temp.charAt(i) - '1' == 0 ||
                    temp.charAt(i) - '2' == 0 ||
                    temp.charAt(i) - '3' == 0 ||
                    temp.charAt(i) - '4' == 0 ||
                    temp.charAt(i) - '5' == 0 ||
                    temp.charAt(i) - '6' == 0 ||
                    temp.charAt(i) - '7' == 0 ||
                    temp.charAt(i) - '8' == 0 ||
                    temp.charAt(i) - '9' == 0 ){
                continue;
            }else {
                temp = temp.substring(0, i);
                break;
            }
        }
        if (temp.length() <=0) return 0;
        Long number = Long.parseLong(temp);
        if (str.charAt(0) - '-' == 0){
            number = number * -1;
        }
        if (number < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return number.intValue();
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }
}
