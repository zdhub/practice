package leetcode;

/**
 * @ClassName Solution26
 * @Descirption 删除排序数组中的重复项，乍一看，没想出来，其实比较简单。类似于冒泡排序，同时冒泡的次数要依次减少。
 * 也可以是双指针里面的快慢指针技巧
 * @Author yizhendong
 * @Date 2019/5/21
 **/
@Easy
public class Solution26 {
    public static void main(String[] args) {
        int[] res = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(res));
        System.out.println("+++++");
        for (int i = 0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]){
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow+1;
    }


    public static int removeDuplicates(int[] nums) {
        int result = nums.length;
        for (int i = 0; i<result - 1;i++){
            if (nums[i] == nums[i+1]){
                i--;
                result--;
                int j = i + 1;
                while ( j <= nums.length - 2){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    j++;
                }
            }
        }
        return result;
    }
}
