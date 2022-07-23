package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Description: How do you find the median from a stream of numbers? The median of a set of numbers is the
 * middle one when they are arranged in order. If the count of numbers is even, the median is defined as the average
 * value of the two numbers in the middle.
 * @Tag: Heap, Design, Two Pointers
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/23
 * @Time:18:22
 */
public class Solution295 {
    public static void main(String[] args) {
        Solution295 solution295 = new Solution295();
        solution295.addNum(1);
        System.out.println(solution295.findMedian());
        solution295.addNum(2);
        System.out.println(solution295.findMedian());
        solution295.addNum(3);
        System.out.println(solution295.findMedian());
        solution295.addNum(4);
        System.out.println(solution295.findMedian());
        solution295.addNum(5);
        System.out.println(solution295.findMedian());
        solution295.addNum(6);
        System.out.println(solution295.findMedian());
        solution295.addNum(7);
    }

    // 正常情况下，PriorityQueue 默认创建是自然顺序，即从小到大的顺序
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
}
