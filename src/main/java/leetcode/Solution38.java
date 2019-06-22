package leetcode;

/**
 * @Description:报数 https://leetcode-cn.com/problems/count-and-say/
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/6/22 15:37
 */
@Easy
public class Solution38 {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(1));
        System.out.println(solution38.countAndSay(2));
        System.out.println(solution38.countAndSay(3));
        System.out.println(solution38.countAndSay(4));
        System.out.println(solution38.countAndSay(5));
        System.out.println(solution38.countAndSay(6));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String cur = "1";
        for (int i = 1; i<n;i++){
            int count = 1;
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while (j<cur.length() - 1){
                if (cur.charAt(j) == cur.charAt(j + 1)){
                    count++;
                }else {
                    sb.append("" + count + cur.charAt(j));
                    count = 1;
                }
                j++;
            }
            sb.append("" + count + cur.charAt(j));
            cur = sb.toString();
        }
        return cur;
    }
}
