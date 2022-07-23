package leetcode;

/**
 * @ClassName Solution96
 * @Descirption 不同的二叉搜索数，给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @Author yizhendong
 * @Date 4/1/2020
 **/
public class Solution96 {
    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(3));
    }

    /**
     * 假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，
     * 其左子树节点个数为1，右子树节点为n-2，
     * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     */
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                num[i] = num[i] + num[i - j] * num[j - 1];
            }
        }
        return num[n];
    }

}
