package leetcode;

/**
 * @Description: 二叉树展开为链表，需要用原地展开的方式来进行。（如果没有这个限制条件的话，则可以先将树进行前序遍历，然后将先序遍历的节点拼为一个链表）
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/12 11:33
 */
@Medium
public class Solution114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法一
     * 1.首先将左子树插入到右子树的地方
     * 2.将原来的右子树接到左子树的最右边的节点上
     * 3.考虑新的右子树的根节点，重复上述过程
     */
    public void flattern(TreeNode root) {
        if (root == null) return;
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

}
