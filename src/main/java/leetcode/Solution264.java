package leetcode;

import java.util.HashSet;

/**
 * @Description:Given an integer n, return the nth ugly number.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/28
 * @Time:23:29
 * @Comment：第一种方法就是常规的，从1依次增加，分别判断每一个N是否是丑数；
 * 第二种方法，在第一种方法的基础之上进行优化，利用hashset进行判断，但是还是会超时；
 * 第三种方法，直接根据之前的丑数，生成下一个最小的丑数，效率最高；
 */
public class Solution264 {
    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        System.out.println(solution264.nthUglyNumber(443));
    }
    private static HashSet<Integer> uglySets = new HashSet<>();
    private static HashSet<Integer> noUglySets = new HashSet<>();

    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int i = 1;
        int number = 1;
        while(i < n){
            number++;
            if (isUgly(number)){
                i++;
                uglySets.add(number);
            } else {
                noUglySets.add(number);
            }
        }
        return number;
    }

    public boolean isUgly(int n){
        boolean beSmall = false;
        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
                if(uglySets.contains(n)) return true;
                if(noUglySets.contains(n)) return false;
                beSmall = true;
            }
            if(n % 3 == 0){
                n = n / 3;
                if(uglySets.contains(n)) return true;
                if(noUglySets.contains(n)) return false;
                beSmall = true;
            }
            if(n % 5 == 0){
                n = n / 5;
                if(uglySets.contains(n)) return true;
                if(noUglySets.contains(n)) return false;
                beSmall = true;
            }
            if (!beSmall) return false;
            if(uglySets.contains(n)) return true;
            if(noUglySets.contains(n)) return false;
        }
        return true;
    }
}
