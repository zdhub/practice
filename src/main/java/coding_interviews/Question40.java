package coding_interviews;

/**
 * 求一个数值的整数次方
 * 有很多细节需要注意：
 * 1.需要是否满足base， exponent都为负数或者0的输入
 * 2.追求极致的情况下，可以利用递归来优化时间复杂度
 * 3.可以利用位运算代替 %取余运算，来判断是奇数还是偶数
 */
public class Question40 {
    public static boolean invalidParameter;
    public static double Power(double base, int exponent){
        if (base == 0 && exponent <= 0){
            invalidParameter = true;
            return -1;
        }
        if (exponent == 0) return 1;
        boolean positive = exponent > 0;

        int absExp = Math.abs(exponent);

        double tempResult = GetPowerOfAbsValue(base, absExp);
        if (positive) return tempResult;
        return 1/ tempResult;
    }

    private static double GetPowerOfAbsValue(double base, int absExp) {
        if (absExp == 0){
            return 1;
        }
        if (absExp == 1){
            return base;
        }
        int tempExp = absExp >> 1;
        double temp = GetPowerOfAbsValue(base, tempExp);
        double result = temp * temp;
        if ((tempExp & 0x1) == 1){
            result = result * base;
        }
        return result;
    }
}
