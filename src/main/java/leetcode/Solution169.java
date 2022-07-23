package leetcode;

/**
 *  Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class Solution169 {


    /**
     * Search the majority element from the 'majority' word's meaning;
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] == majority){
                count++;
            } else if (count == 0) {
                majority = nums[i];
                count = 1;
            } else{
                count--;
            }
        }
        if (count > 0){
            return majority;
        }
        return -1;
    }


    /**
     * The second way to search the majority element, which uses the partition function.
     * @param nums
     * @return
     */
    public int majorityElementV1(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int middle = (start + end)/2;

        int index = partition(nums, start, end);
        while(index != middle){
            if (index < middle){
                index = partition(nums, index+1, end);
            } else {
                index = partition(nums, start, index-1);
            }
        }
        return nums[middle];
    }
    public int partition(int[] nums, int left, int right) {
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
