package leetcode;

import java.util.*;

/**
 * @Description:二叉树的最近公共祖先
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/12 13:20
 */
public class Solution236 {
    private TreeNode ans;

    /**
     * 两种方法，一种是通过递归，判断某个节点的左，中，右的布尔标记，如果左子树含有任意一个，则标记左节点true
     * 如果右子树含有任意一个，则标记右节点为true，如果本身是p或者q，则中为true
     * 如果左中右任意两个为true，则最近公共婆祖先已经找到
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public Solution236() {
        // Variable to store LCA node.
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = this.recurseTree(root.left, p, q) ? 1 : 0;
        int right = this.recurseTree(root.right, p, q) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if (left + right + mid >= 2) ans = root;
        return (left + right + mid > 0);
    }

    /**
     * 第二种方法，使用父节点来迭代
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        stack.push(root);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }
}
