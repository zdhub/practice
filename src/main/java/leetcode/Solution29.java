package leetcode;

/**
 * @ClassName Solution29
 * @Descirption 两数相除
 * @Author yizhendong
 * @Date 2019/5/26
 **/
@Medium
@TriedButFaild
public class Solution29 {
    public static void main(String[] args) {
        System.out.println(divideBest(7, -3));
    }

    //可以解决，但是时间花费太高
    public static int divide(int dividendInt, int divisorInt) {
        long dividend = dividendInt;
        long divisor = divisorInt;
        if (dividend == -2147483648 && divisor == -1) return 2147483647;
        if (dividend == -2147483648 && divisor == 1) return -2147483648;

        if (dividend == 0) return 0;
        if (dividend == divisor ) return 1;
        int fuhao = 0;

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)){
            fuhao = 1;
            if (dividend < 0){
                dividend = -dividend;
                divisor = -divisor;
            }
        }else {
            if (dividend < 0){
                dividend = -dividend;
            }else {
                divisor = -divisor;
            }
            fuhao = -1;
        }
        int result = 0;
        while (dividend >= divisor ){
            dividend = dividend - divisor;
            if (result == Integer.MAX_VALUE) continue;
            result++;
        }
        return fuhao == 1 ? result: -result;
    }

    /**
     * 需要注意的地方：
     * 1.将int专为long来处理
     * 2.使用位计算来处理
     * 3.需要注意负数最小值的溢出
     */
    public static int divideBest(int dividend, int divisor){
        if (divisor == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean negative;
        //非常妙的处理方式
        negative = (dividend ^ divisor ) < 0;
        int result = 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        for (int i = 31;i>= 0;i--){
            if ((t>>i) >= d){
                result = result + (1<<i);
                t = t - (d<<i);
            }
        }
        return negative ? -result : result;
    }

}
