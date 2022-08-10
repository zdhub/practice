package leetcode;

/**
 * @Description:Given an integer n, count the total number of digit 1 appearing
 * in all non-negative integers less than or equal to n.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/25
 * @Time:23:48
 * @Comment: 这个问题比较难理解，思考了很久，才初步理解清楚
 * 这个问题也是剑指Offer英文版本的第73题
 */
@Hard

/*
 思考有一个数字xyzdabc
 我们现在根据千位上的d来判断有多少中千位为1的情况。
 这里会有三种情况来讨论：分别是当前位为0；当前位为1；当前位大于1；----至于说为什么要这么划分，应该是找规律得出来的...

 1. 当d为0时，此时会有 xyz * 1000种情况的 d为1的数字
 2. 当d为1时，此时会有 xyz * 1000 + abc + 1 种情况的 d为1的数字
 3. 当d大于1时，此时会有 xyz * 1000 + 1000 种情况的 d为1的数字

 举个例子：456000这个数字，
    4551000 to 4551999 (1000)
    4541000 to 4541999 (1000)
    4531000 to 4531999 (1000)
    ...
    1000 to 1999 (1000)
    共有456 * 1000 种情况，符合上述的规律
再举另一个例子，4561234这个数字
    4561000-4561234 (1234+1)
    4551000 to 4551999 (1000)
    4541000 to 4541999 (1000)
    4531000 to 4531999 (1000)
    ...
    1000 to 1999 (1000)
    则共有 456 * 1000 + 1234 + 1 种情况

再举另外一个例子，4562234这个数字
    4561000 to 4561999 (1000)
    4551000 to 4551999 (1000)
    4541000 to 4541999 (1000)
    4531000 to 4531999 (1000)
    ...
    1000 to 1999 (1000)
则共有 456 * 1000 + 1000 种情况
 */
public class Solution233 {
    public int countDigitOne(int number) {
        if (number < 0) return 0;
        int q = number, x = 1, count = 0;
        do {
            int digit = q % 10;
            q /= 10;
            count += q * x;
            if (digit == 1) count += number % x + 1;
            if (digit > 1) count += x;
            x *= 10;
        } while (q > 0);
        return count;
    }

    public static void main(String[] args) {
        Solution233 solution233 = new Solution233();
        System.out.println(solution233.countDigitOne(13));
    }

}
