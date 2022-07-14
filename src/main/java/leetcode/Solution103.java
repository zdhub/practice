package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: Binary Tree Zigzag Level Order Traversal
 * @vertion:1.0
 * @author:yizhendong
 * @date:2022/7/14
 * @time:23:07
 */
@Medium
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stackOdd = new Stack<TreeNode>();
        Stack<TreeNode> stackEven = new Stack<TreeNode>();
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        stackOdd.push(root);
        while(stackOdd.size() != 0 || stackEven.size() != 0){
            List<Integer> oddList = new LinkedList<>();
            while(stackOdd.size() != 0){
                TreeNode node = stackOdd.pop();
                oddList.add(node.val);
                if(node.left != null) stackEven.push(node.left);
                if(node.right != null) stackEven.push(node.right);
            }
            if(oddList.size() != 0) list.add(oddList);
            List<Integer> evenList = new LinkedList<>();
            while(stackEven.size() != 0){
                TreeNode node = stackEven.pop();
                evenList.add(node.val);
                if(node.right != null) stackOdd.push(node.right);
                if(node.left != null) stackOdd.push(node.left);
            }
            if(evenList.size() != 0) list.add(evenList);
        }
        return list;
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
