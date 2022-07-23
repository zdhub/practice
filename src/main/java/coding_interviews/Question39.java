package coding_interviews;

/**
 * Get Two Missing Numbers
 */
public class Question39 {
    // Version 1, get these 2 numbers from Arithmetic calculation
    public static int[] GetTwoNumber(int[] number){
        int sum1 = 0;
        int product1 = 1;
        for (int i = 0; i < number.length; i++) {
            sum1 += number[i];
            product1 *= number[i];
        }
        int sum2 = 0;
        int product2 = 1;
        for (int i = 1; i <= number.length + 2; i++) {
            sum2 += i;
            product2 *= i;
        }

        int[] result = new int[]{0, 0};
        int s = sum2 - sum1;
        int p = product2/ product1;
        result[0] = (s + (int)(Math.sqrt(s * s - 4 * p))) / 2;
        result[1] = s - result[0];
        return result;
    }

    public static void main(String[] args) {
        int[] number = new int[]{1, 2, 3, 4, 5, 6};
        int[] result = GetTwoNumber(number);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
