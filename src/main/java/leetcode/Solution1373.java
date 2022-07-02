package leetcode;

/**
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 */
@Hard
public class Solution1373 {
    int maxSum = 0;

    public class NodePair {
        int min, max, sum;
    }

    public int maxSumBST(TreeNode root) {
        NodePair temp = new NodePair();
        temp = getSum(root);
        return Math.max(maxSum, 0);
    }

    public NodePair getSum(TreeNode root){
        if (root == null) {
            NodePair n = new NodePair();
            n.max = Integer.MIN_VALUE;
            n.min = Integer.MAX_VALUE;
            n.sum = 0;
            return n;
        }
        NodePair main = new NodePair();
        NodePair left = getSum(root.left);
        NodePair right = getSum(root.right);
        if (root.val > left.max && root.val < right.min) {
            main.min = Math.min(left.min, Math.min(root.val, right.min));
            main.max = Math.max(right.max, Math.max(root.val, left.max));
            main.sum = root.val + left.sum + right.sum;
            maxSum = Math.max(main.sum, maxSum);
        } else {
            main.min = Integer.MAX_VALUE;
            main.max = Integer.MIN_VALUE;
            main.sum = Math.max(left.sum, right.sum);
        }
        return main;
    }


    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
