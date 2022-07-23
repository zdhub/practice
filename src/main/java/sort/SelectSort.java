package sort;

/**
 * @Description:选择排序,选择排序的概念就是：首先在未排序的队列中找到最小（大）的元素，存放到排序队列的起始位置，
 * 然后，从剩余未排序的元素中继续寻找最小（大）的元素，然后放到已经排序的末尾，依次类推。
 * 时间复杂度为O(N2)
 * 特点：排序复杂度不受输入数据的影响
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/14 21:00
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void sort(int[] nums) {
        int maxIndex;
        for (int i = 0; i < nums.length; i++) {
            maxIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
