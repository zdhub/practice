package leetcode;

/**
 * 计算一个数字中的二级制中的1的数量
 * 需要注意的是，在java中，不可以使用 >>，而需要使用>>>，因为如果使用前者的话，会把符号也依次填充，而使用后者的话，其意义是轮转
 */

@Easy
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count = count + (n & 1);
            n = n >>> 1;
        }
        return count;
    }
}
