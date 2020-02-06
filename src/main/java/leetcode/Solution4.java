package leetcode;

/**
 * @ClassName Solution4
 * @Descirption 寻找两个有序数组的中位数 时间复杂度要求为O(N)
 * @Author yizhendong
 * @Date 6/2/2020
 **/
public class Solution4 {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n % 2 != 0) {
                return 1.0 * nums2[n / 2];
            }
            return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
        }
        if (n == 0) {
            if (m % 2 != 0) {
                return 1.0 * nums1[m / 2];
            }
            return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
        }
        int total = m + n;
        if ((total & 1) == 1) {
            return find_kth(nums1, 0, nums2, 0, total / 2 + 1);
        }
        return (find_kth(nums1, 0, nums2, 0, total / 2) + find_kth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
    }

    private double find_kth(int[] a, int a_begin, int[] b, int b_begin, int k) {
        if (a_begin >= a.length) {
            return b[b_begin + k - 1];
        }
        if (b_begin >= b.length) {
            return a[a_begin + k - 1];
        }
        if (k == 1) {
            return Math.min(a[a_begin], b[b_begin]);
        }
        int mid_a = Integer.MAX_VALUE;
        int mid_b = Integer.MAX_VALUE;
        //mid_a, mid_b 分别代表a数组，b数组中第k/2个数
        if (a_begin + k / 2 - 1 < a.length) {
            mid_a = a[a_begin + k / 2 - 1];
        }
        if (b_begin + k / 2 - 1 < b.length) {
            mid_b = b[b_begin + k / 2 - 1];
        }
        if (mid_a < mid_b) {
            return find_kth(a, a_begin + k / 2, b, b_begin, k - k / 2);
        }
        return find_kth(a, a_begin, b, b_begin + k / 2, k - k / 2);
    }
}
