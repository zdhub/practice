package com.example.spring.practice.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序, 每次都找最小的数
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/10/15 0:20
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 7, 9, 0, 3, 5, 1, 8};
        selectNum(numbers);
        Arrays.stream(numbers).forEach(item -> {
            System.out.print(item);
        });
    }

    /**
     * 时间复杂度平均n2 最坏n2 最好n2
     * 有可能不稳定,如{5,5,2}
     * 空间复杂度1
     * @param numbers
     */
    private static void selectNum(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[index]) {
                    index = j;
                }
            }
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }
    }
}
