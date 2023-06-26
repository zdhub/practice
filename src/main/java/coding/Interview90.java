package coding;

import leetcode.Medium;

/**
 * @Description: Given a positive value s, print all sequences with continuous numbers (with two numbers at
 * least) whose sum is s.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/20
 * @Time:13:00
 * @Comment: 我刚开始思考的是循环的方式，直接判断除数是否是偶数，找到规律即可；除了这个方式，还有一种方式是双指针，循环；
 */
@Medium
public class Interview90 {
    public void findContinuousSequence(int sum){
        if(sum < 3) return;
        for (int i = 2; i < sum/2 ;i ++){
            boolean even = false;
            if (i % 2 == 0) even = true;
            if ( !even && sum % i == 0) {
                int start = sum / i - (i / 2);
                if (start <= 0) break;
                PrintSequence(start, i);
            }
            if ( even && sum % i == i / 2){
                int start = (sum + i / 2) / i - (i / 2);
                if (start <= 0) break;
                PrintSequence(start, i);
            }
        }
    }

    public void findContinuousSequenceV2(int sum){
        if (sum < 3)
            return;
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle){
            if (curSum == sum){
                PrintSequence(small, big - small + 1);
            }
            while (curSum > sum && small < middle){
                curSum = curSum - small;
                small ++;
                if (curSum == sum){
                    PrintSequence(small, big - small + 1);
                }
            }
            big++;
            curSum = curSum + big;
        }
    }
    public void PrintSequence(int start, int count){
        for (int i = 0; i < count ; i++) {
            System.out.println(start + i);
        }
    }

    public static void main(String[] args) {
        int s = 27;
        Interview90 interview90 = new Interview90();
        interview90.findContinuousSequenceV2(s);
    }
}
