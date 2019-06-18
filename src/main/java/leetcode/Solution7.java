package leetcode;

/**
 * @ClassName Solution7
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/31
 **/
public class Solution7 {
    public static int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        if(x == 0 ) return x;
        boolean greaterThanZero = true;
        if(x < 0 ) {
            greaterThanZero = false;
            x = x * -1;
        }
        String number = String.valueOf(x);
        char[] chars = number.toCharArray();
        reverseChar(chars);
        String reverseNumber = getString(chars);
        Long temp = Long.parseLong(reverseNumber);
        if(!greaterThanZero) temp = temp * -1;
        if(temp < Integer.MIN_VALUE) return 0;
        if(temp > Integer.MAX_VALUE) return 0;
        return temp.intValue();
    }

    public static void reverseChar(char[] chars){
        int length = chars.length;
        for(int i = 0;i<length/2;i++){
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;
        }
    }

    public static String getString(char[] chars){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<chars.length;i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

}
