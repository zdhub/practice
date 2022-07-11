package leetcode;

/**
 * 判断一个数是否是另一个树的子树。子树的概念，每一个节点的值都相同，除此之外，每一个叶子节点也相同。
 * 2022年7月13日
 */
@Easy
public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (root.val == subRoot.val){
            if(EqualSubTree(root.left, subRoot.left) && EqualSubTree(root.right, subRoot.right)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean EqualSubTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root != null && subRoot == null) return false;
        if (root == null && subRoot != null) return false;
        if (root.val != subRoot.val) return false;
        return EqualSubTree(root.left, subRoot.left) && EqualSubTree(root.right, subRoot.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
