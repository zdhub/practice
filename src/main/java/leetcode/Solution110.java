package leetcode;

/**
 * @Description: Given a binary tree, determine if it is height-balanced.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/11
 * @Time:22:56
 */
@Easy
public class Solution110 {
    public static boolean result = true;
    public boolean isBalancedV2(TreeNode root){
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root){
        if(root == null || !result) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1){
            result = false;
        }
        return 1 + Math.max(l, r);
    }

    public boolean isBalancedV1(TreeNode root) {
        if(root == null) return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;
        if(diff > 1 || diff < -1) return false;
        return isBalancedV1(root.left) && isBalancedV1(root.right);
    }

    public int TreeDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return Math.max(leftDepth+1, rightDepth+1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
