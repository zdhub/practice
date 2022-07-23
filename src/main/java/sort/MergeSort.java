package sort;

/**
 * @Description:归并排序 特点：排序复杂度不受输入数据的影响，但是表现比排序好的多，始终都是O(nlogn)
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/14 21:55
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            nums[start + p] = temp[p];
        }
    }
}
