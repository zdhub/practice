package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:在未排序的数组中找到第k个最大的元素。请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/17 17:34
 * @Comment: 需要对比不同的解法
 * @Solution:
 *  1.有很多种不同的解法，首先可以想到的就是先对所有的元素排序，然后返回其中第K大的数。时间复杂度 O(nlogn);
 *  2.第二种方法就是利用快排的思想，使用partition函数。时间复杂度O(n)。但是也有缺点，缺点在于a.要把所有数加载到内存中；b.要修改原数组
 *  3.第三种方法就是使用一个大顶堆heap，对应java中的PriorityQueue。时间复杂度O(nlogk)。不存在第二种方法的缺点。
 *
 */
@Medium
public class Solution215 {
    public static void main(String[] args) {
        int[] num = {3, 2, 3, 1, 2, 4, 5, 6, 7};
        Solution215 solution215 = new Solution215();
        System.out.println(solution215.findKthLargest(num, 4));
    }

    /**
     * 使用了大顶堆，将所有的元素加入堆中，并保持堆的大小小于等于K。这样，堆中就保留了前K个最大元素。
     * 往大小为K的堆中添加元素的时间复杂度为O(logk),将该操作重复N次，则时间复杂度为O(Nlogk);
     * 空间复杂度为O(K);
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    /**
     * 参考快速排序
     */
    public int findKthLargest2(int[] nums, int k) {
        k--;
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (start < end) {
            index = partition(nums, start, end);
            if (index > k) end = index - 1;
            else if (index < k) start = index + 1;
            else return nums[index];
        }
        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int pivot = nums[start];
        while (i < j) {
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
        }
        nums[i] = pivot;
        return i;
    }
}
