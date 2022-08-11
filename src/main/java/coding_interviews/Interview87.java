package coding_interviews;

import leetcode.Easy;

/**
 * @Description: Given an increasingly sorted array and a number s, is there a pair of two numbers in the array
 * whose sum is s?
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/11
 * @Time:23:16
 */
@Easy
public class Interview87 {
    boolean hasPairWithSum(int numbers[], int sum){
        boolean found = false;
        int start = 0;
        int end = numbers.length - 1;
        while(end > start){
            int temp = numbers[start] + numbers[end];
            if (sum == temp){
                return true;
            } else if (sum < temp){
                start++;
            } else end--;
        }
        return found;
    }
}
