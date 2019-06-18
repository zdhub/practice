package leetcode;

/**
 * @ClassName Solution12
 * @Descirption
 * @Author yizhendong
 * @Date 2019/4/1
 **/
public class Solution12 {
    public static String intToRoman(int num) {
        return toString(num, "");
    }

    public static String toString(int num, String str){
        if(num == 0){
            return str;
        }else if(num >= 1000){
            int mNum = num / 1000;
            for(int i = 0 ;i<mNum;i++){
                str = str + "M";
            }
            int mResult = num - mNum * 1000;
            return toString(mResult, str);
        }else if(num >= 900){
            int m2Num = num - 900;
            str = str + "CM";
            return toString(m2Num, str);
        }else if(num >= 500){
            int dNum = num - 500;
            str = str + "D";
            return toString(dNum, str);
        }else if(num >= 400){
            int d2Num = num - 400;
            str = str + "CD";
            return toString(d2Num, str);
        }else if(num >= 100){
            int cNum = num / 100;
            for(int i = 0 ;i<cNum;i++){
                str = str + "C";
            }
            int cResult = num - cNum * 100;
            return toString(cResult, str);
        }else if(num >= 90){
            int c2Num = num - 90;
            str = str + "XC";
            return toString(c2Num, str);
        }else if(num >= 50){
            int lNum = num - 50;
            str = str + "L";
            return toString(lNum, str);
        }else if(num >= 40){
            int l2Num = num - 40;
            str = str + "XL";
            return toString(l2Num, str);
        }else if(num >= 10){
            int xNum = num / 10;
            for(int i = 0 ;i<xNum;i++){
                str = str + "X";
            }
            int xResult = num - xNum * 10;
            return toString(xResult, str);
        }else if(num >= 9){
            int x2Num = num - 9;
            str = str + "IX";
            return toString(x2Num, str);
        }else if(num >= 5){
            int vNum = num - 5;
            str = str + "V";
            return toString(vNum, str);
        }else if(num >= 4){
            int v2Num = num - 40;
            str = str + "IV";
            return toString(v2Num, str);
        }else {
            for(int i = 0 ;i<num;i++){
                str = str + "I";
            }
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3).equals("III"));
        System.out.println(intToRoman(4).equals("IV"));
        System.out.println(intToRoman(9).equals("IX"));
        System.out.println(intToRoman(58).equals("LVIII"));
        System.out.println(intToRoman(1994).equals("MCMXCIV"));
    }

}
