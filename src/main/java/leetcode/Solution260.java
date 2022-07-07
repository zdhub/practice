package leetcode;

/**
 * 获取数组中为二的两个出现次数为一的数字
 * 很难想到，一般只会想到进行一次轮询异或，但是很难想到根据第一次异或的结果再和数组进行划分，然后分别得到两个数字
 */

@Medium
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++){
            temp = temp ^ nums[i];
        }

        temp = temp&(-temp);

        int[] result = new int[]{0, 0};
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & temp) == 0){
                result[0] = result[0] ^ nums[i];
            } else {
                result[1] = result[1] ^ nums[i];
            }
        }
        return result;
    }
}
