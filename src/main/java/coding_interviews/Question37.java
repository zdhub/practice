package coding_interviews;

/**
 * 计算m和n两个数字的二进制的数对比后，不同的位数
 * 1.第一步，先异或
 * 2.第二部，用得到的结果做之前类似的左移轮转
 */
public class Question37 {
    public static int DifferentBit(int m, int n){
        int temp = m ^ n;
        int count = 0;
        while (temp != 0 ){
            count = count + (n & 1);
            temp = temp >>> 1;
        }
        return count;
    }
}
