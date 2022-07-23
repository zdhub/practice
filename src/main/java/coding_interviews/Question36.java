package coding_interviews;

/**
 * 判断一个数字是否是2的幂
 */
public class Question36 {
    public static boolean PowerOfK(int n){
        int x = n & (n -1);
        return n != 0 && x == 0;
    }

    public static void main(String[] args) {
        System.out.println(PowerOfK(8));
        System.out.println(PowerOfK(7));
    }
}
