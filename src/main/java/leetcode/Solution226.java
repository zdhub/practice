package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 反转二叉树 两种方式，一种是递归，还有一种是迭代
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/12 11:24
 *  2022年7月11日再次做，一次成功
 */
@Easy
public class Solution226 {


    /**
     * 递归方法
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root){
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * 迭代方法
     */
    public TreeNode invertTree2(TreeNode root){
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
