package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Description:给出一个区间的集合，请合并所有重叠的区间。 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/27 23:13
 */
@Medium
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int prevIndex = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Interval> intervalArrayList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            intervalArrayList.add(interval);
        }
        Collections.sort(intervalArrayList, new IntervalComparator());
        LinkedList<Interval> arrayList = new LinkedList<>();
        for (Interval interval : intervalArrayList) {
            if (arrayList.isEmpty() || arrayList.getLast().end < interval.start) {
                arrayList.add(interval);
            } else {
                arrayList.add(merge(arrayList.pollLast(), interval));
            }
        }
        int[][] result = new int[arrayList.size()][2];
        int i = 0;
        for (Interval interval : arrayList) {
            int[] item = new int[2];
            item[0] = interval.start;
            item[1] = interval.end;
            result[i] = item;
            i++;
        }
        return result;
    }

    private Interval merge(Interval interval, Interval interval1) {
        Interval result = new Interval(Math.min(interval.start, interval1.start), Math.max(interval.end, interval1.end));
        return result;
    }

    private class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1;
        }
    }
}
