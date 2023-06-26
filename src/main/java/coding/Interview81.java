package coding;

import leetcode.Hard;

/**
 * @Description: Count Reversed Pairs
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/7
 * @Time:20:54
 * @Comment: 有两种解法，第一种就是很直观的暴力循环解法，时间复杂度为O(n*n);还有一种解法，在看了书和评论之后，才理解，即归并排序解法。需要重点学习。
 */
@Hard
public class Interview81 {
    public static void main(String[] args) {
        Interview81 interview81 = new Interview81();
        int[] numbers;
        numbers =new int[]{7,6,5,4,3,2,1};
        System.out.println(interview81.countReversedPairs(numbers));
    }
    public int countReversedPairs(int[] numbers){
        int[] buffer = new int[numbers.length];
        return countCore(numbers, 0, numbers.length - 1, buffer);
    }

    private int countCore(int[] numbers, int start, int end, int[] buffer) {
        if (start >= end) {
            return 0;
        }
        int middle = (start + end) / 2;
        int left = countCore(numbers, start, middle, buffer);
        int right = countCore(numbers, middle + 1, end, buffer);
        int between = mergeSort(numbers, start, middle, end, buffer);
        return left + right + between;
    }

    private int mergeSort(int[] numbers, int start, int middle, int end, int[] buffer){
        int i = middle;
        int j = end;
        int k = end;
        int count = 0;
        while (i >= start && j >= middle + 1){
            if (numbers[i] > numbers[j]){
                buffer[k--] = numbers[i--];
                count += j - middle;
            } else {
                buffer[k--] = numbers[j--];
            }
        }
        while (i >= start){
            buffer[k--] = numbers[i--];
        }
        while (j>= middle + 1){
            buffer[k--] = numbers[j--];
        }
        for (int m = start; m < end; m++){
            numbers[m] = buffer[m];
        }
        return count;
    }
}
