package com.example.spring.practice.sort;


import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description:
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/10/14 23:56
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {2,4,6,7,9,0,3,5,1,8};
        sortNum(numbers);
        Arrays.stream(numbers).forEach(item -> {System.out.print(item);});
    }

    /**
     * 时间复杂度最差n2 平均n2 最好n
     * 空间复杂度 1
     * 是一种稳定排序
     * @param numbers
     */
    private static void sortNum(int[] numbers) {
        for (int i = 0;i<numbers.length-1;i++){
            for (int j = 0;j<numbers.length-i-1;j++){
                if (numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
}
