package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: Maximum Depth of Binary Tree
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/11
 * @Time:22:34
 * @Comment: 存在很多种方法，一种是使用递归，代码十分简洁；还有就是使用迭代的方式，这种方式看起来比递归要复杂一点
 */
@Easy
public class Solution104 {
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth+1, rightDepth+1);
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);
        int depth = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()) depth++;
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                if(node.left != null) stack2.push(node.left);
                if(node.right != null) stack2.push(node.right);
            }
            if(!stack2.isEmpty()) depth++;
            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                if(node.left != null) stack1.push(node.left);
                if(node.right != null) stack1.push(node.right);
            }
        }
        return depth;
    }

    public int maxDepthV3(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }

        return count;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
