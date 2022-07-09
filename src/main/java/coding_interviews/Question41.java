package coding_interviews;

import leetcode.Medium;

/**
 * 给定一个N，输出从1到n位数最大值
 * 有两种解法，第一种是直观的用数组模拟加法运算；
 * 还有一种是递归
 */

/**
 * 需要重点关注，第一次做的时候，完全没有思路。2022年7月9日
 */
@Medium
public class Question41 {

    public static void main(String[] args) {
        Print1ToMaxOfNDigits(2);
//        Print1ToMaxOfNDigitsV2(2);
    }

    /**
     * 这是第一种解法，比较直观，但是细节比较多，涉及到加法，以及如何优雅的跳过开头为0的数的打印
     * @param n
     */
    public static void Print1ToMaxOfNDigits(int n){
        if (n <= 0){
            return;
        }
        int[] number = new int[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = 0;
        }
        while (!Increment(number)){
            PrintNumber(number);
        }
    }
    public static void Print1ToMaxOfNDigitsV2(int n){
        if (n <= 0){
            return;
        }
        int[] number = new int[n ];
        for (int i = 0; i < number.length; i++) {
            number[i] = 0;
        }
        for (int i = 0; i < 10; i++) {
            number[0] = i;
            Print1ToMaxOfNDigitsV2Recursively(number, n, 0);
        }
    }

    private static void Print1ToMaxOfNDigitsV2Recursively(int[] number, int length, int index) {
        if (index == length - 1){
            PrintNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++){
            number[index + 1] = i;
            Print1ToMaxOfNDigitsV2Recursively(number, length, index + 1);
        }
    }

    private static void PrintNumber(int[] number) {
        boolean isBeginning0 = true;
        for (int i = 0; i < number.length;i ++){
            if (isBeginning0 && number[i] != 0){
                isBeginning0 = false;
            }
            if (!isBeginning0){
                System.out.printf("%s", number[i]);
            }
        }
        System.out.println("");
    }

    private static boolean Increment(int[] number) {
        boolean takeOver = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i-- ){
            int nSum = number[i] + nTakeOver;
            if (i == nLength - 1){
                nSum ++;
            }
            if(nSum >= 10){
                if (i == 0){
                    takeOver = true;
                } else {
                    nTakeOver = 1;
                    nSum = nSum - 10;
                    number[i] = nSum;
                }
            } else {
                number[i] = nSum;
                break;
            }
        }
        return takeOver;
    }
}
