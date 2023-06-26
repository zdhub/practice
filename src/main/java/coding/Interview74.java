package coding;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:Big numbers can be formed if numbers in an array are concatenated together. How do you
 * print the minimum concatenated number of a given array?
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/27
 * @Time:22:54
 * @Comment: 这个题我有思路，但是Comparator方法忘记差不多了，需要复习
 * 知识点：Comparable和Comparator的区别。
 * Comparable是排序接口，需要一个类来实现他，属于内部比较；
 * Comparator是排序比较器，如果要对某些类进行排序，可以建立一个这个类对应的排序比较器；
 *
 * 如果某个类中的属性可以比较，那么可以用Comparable进行对比；
 * 如果要对比的不是某个类，而是某些基本类型，比如String或者Integer等，则可以使用Comparator，构建一个比较器
 */
public class Interview74 {
    public int[] PrintMinNumber(int[] numbers){
        String[] strNumber = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumber[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumber, new NumberComparator());

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.valueOf(strNumber[i]);
        }
        return numbers;
    }
    // 不可以使用这种
    static class NumberComparable implements Comparable<String>{

        @Override
        public int compareTo(String o) {
            return 0;
        }
    }
    static class NumberComparator implements Comparator<String>{
        public int compare(String str1, String str2){
            String stra = str1 + str2;
            String strb = str2 + str1;
            return stra.compareTo(strb);
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[4];
        numbers[0] = 2;
        numbers[1] = 24;
        numbers[2] = 21;
        numbers[3] = 213;
        Interview74 interview74 = new Interview74();
        numbers = interview74.PrintMinNumber(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
