package com.example.spring.practice.sort;

import java.util.Arrays;

/**
 * @Description:快速排序，空间复杂度为O(nlogn)，时间复杂度最好为O(nlogn)，
 * 最差为O（n2），平均为O(nlogn),不稳定
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/10/15 22:52
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 7, 9, 0, 3, 5, 1, 8};
        sortNum(numbers);
        Arrays.stream(numbers).forEach(item -> {
            System.out.print(item);
        });
    }

    private static void sortNum(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] numbers, int l, int r) {
        if (l >= r) {
            return;
        }
        int target = numbers[l];
        int pivot = l;
        for (int i = l + 1; i <= r; i++) {
            if (numbers[i] < target) {
                swap(numbers, ++pivot, i);
            }
        }
        swap(numbers, l, pivot);
        quickSort(numbers, l, pivot - 1);
        quickSort(numbers, pivot + 1, r);
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
