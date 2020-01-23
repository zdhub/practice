package sort;

/**
 * @Description:冒泡排序,时间复杂度为O(N2)
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/14 20:28
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}
