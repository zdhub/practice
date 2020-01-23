package sort;

/**
 * @Description:
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/14 23:02
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right){
            return;
        }
        int pivotPosition = partition(nums, left, right);
        quickSort(nums, left, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
