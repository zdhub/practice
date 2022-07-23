package leetcode;

class Solution153 {
     public int findMinV1(int[] nums) {
         if(nums.length <= 2){
             return Math.min(nums[0], nums[nums.length - 1]);
         }
         return findSubMin(nums, 0, nums.length-1);
     }

     public int findSubMin(int[] nums, int start, int end){
         if (start + 1 >= end && nums[start] > nums[end]){
             return nums[end];
         }
         int middle = (start + end) / 2;
         if (nums[start] < nums[middle] && nums[middle] < nums[end]){
             return nums[start];
         }
         if (nums[start] > nums[middle]){
             return findSubMin(nums, start, middle);
         } else {
             return findSubMin(nums, middle, end);
         }
     }

     //This is the most elegant solution.
    public int findMinV2(int[] nums){
        int left = 0, right = nums.length-1;
        while(left < right){
            int middle = (left + right)/2;
            if(nums[middle] > nums[right]){
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
}