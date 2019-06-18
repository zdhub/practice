package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution22
 * @Descirption 括号生成 中等
 * @Author yizhendong
 * @Date 2019/5/14
 **/
@TriedButFaild
@Medium
    public class Solution22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res,"", 0, 0, n);
        return res;
    }

    private static void generate(List<String> res,String ans, int i1, int i2, int n) {
        if (i1 > n) return;
        if (i2 > n) return;
        if (i1 == n && i2 == n) res.add(ans);

        if (i1 >= i2){
            String ans1 = new String(ans);
            generate(res, ans + "(", i1 + 1, i2, n );
            generate(res, ans1 + ")", i1, i2+1, n);
        }
    }
}
