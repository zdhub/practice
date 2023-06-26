package coding;

/**
 * @Description: Left Rotation in a String. For example, if the input string is “abcdefg” and a number 2, two characters are rotated and the result is
 * “cdefgab”
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/20
 * @Time:17:37
 * @Comment: 这个题不是很难。我直观想到的方法是先Reverse，然后根据n再分阶段reverse即可。看了Leetcode相关的题解，还有更简单的方式。
 */
public class Interview92 {
    // 这是看了网上题解的方案，相当简单，都用不到反转
    public String rotation(String sentence, int n){
        int length = sentence.length();
        n = n % length;
        return sentence.substring(n) + sentence.substring(0, n);
    }

    public String rotationV2(String sentence, int n){
        int length = sentence.length();
        n = n % length;
        String reverseStr = reverse(sentence);
        int r = length - n;
        return reverse(reverseStr.substring(0, r)) + reverse(reverseStr.substring(r));
    }

    private String reverse(String sentence) {
        char[] chars = sentence.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Interview92 s = new Interview92();
        System.out.println(s.rotationV2("abcdefg", 2));
    }
}
