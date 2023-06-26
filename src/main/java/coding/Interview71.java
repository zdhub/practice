package coding;

import leetcode.Easy;

import java.util.ArrayList;

/**
 * @Description: Please implement a function that finds the intersection of two sorted arrays. Assume numbers
 * in each array are unique
 * @Tag: Hash Table; Two Pointers; Sorting
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/24
 * @Time:14:41
 */
@Easy
public class Interview71 {
    public ArrayList<Integer> intersection(int[] nums1, int[] nums2) {
        int i1 = 0;
        int i2 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i1 < nums1.length && i2 < nums2.length){
            if(nums1[i1] == nums2[i2]){
                result.add(nums1[i1]);
            } else if (nums1[i1] < nums2[i2]){
                i1++;
            } else {
                i2++;
            }
        }
        return result;
    }
}
