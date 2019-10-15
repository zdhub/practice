package com.example.spring.practice.sort;

import java.util.Arrays;

/**
 * @Description:插入排序，时间复杂度最坏情况是n2，最好是n，平均是n2，空间复杂度为o(1)，是一个稳定的排序方法
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/10/15 22:32
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 7, 9, 0, 3, 5, 1, 8};
        sortNum(numbers);
        Arrays.stream(numbers).forEach(item -> {
            System.out.print(item);
        });
    }

    private static void sortNum(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int preIndex = i - 1;
            int current = numbers[i];
            while (preIndex >= 0 && numbers[preIndex] > current) {
                numbers[preIndex + 1] = numbers[preIndex];
                preIndex--;
            }
            numbers[preIndex + 1] = current;
        }
    }
}
