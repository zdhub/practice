package coding_interviews;

import leetcode.Medium;

import java.util.Arrays;

/**
 * @Description:  Get Three Numbers with Sum 0
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/16
 * @Time:23:14
 */
@Medium
public class Interview88 {
    public boolean hasTripleWithSum0(int[] numbers){
        boolean found = false;
        if (numbers.length < 3) return false;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            int sum = -numbers[i];
            found = hasPairWithSum(numbers, sum, i);
            if (found) break;
        }
        return found;
    }

    public boolean hasPairWithSum(int[] numbers, int sum, int excludeIndex){
        boolean found = false;
        int end = numbers.length - 1;
        int start = 0;
        while (start < end){
            if (start == excludeIndex){
                start++;
            }
            if (end == excludeIndex){
                end--;
            }
            int count = numbers[start] +  numbers[end];
            if (count == sum) {
                found = true;
                break;
            } else if (count < sum){
                start++;
            } else {
                end--;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] numbers = new int[6];
        numbers[0] = -10;
        numbers[1] = -6;
        numbers[2] = -1;
        numbers[3] = 1;
        numbers[4] = 6;
        numbers[5] = 7;
        Interview88 interview88 = new Interview88();
        System.out.println(interview88.hasTripleWithSum0(numbers));
    }
}
