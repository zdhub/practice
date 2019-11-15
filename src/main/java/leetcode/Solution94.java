package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 给定一个二叉树，返回它的中序 遍历。 使用递归的时候很简单，大概10分钟就实现了。使用栈的方法一下子没想出来
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/15 8:26
 */
@Medium
public class Solution94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode rightChild = new TreeNode(3);
        TreeNode right2thChild = new TreeNode(0);
        rightChild.left = right2thChild;
        root.right = rightChild;
        Solution94 solution94 = new Solution94();
        List<Integer> result = solution94.inorderTraversal2(root);
        result.stream().forEach(i -> System.out.println(i));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        return inorderTraversalWithList(root, result);
    }

    private List<Integer> inorderTraversalWithList(TreeNode root, List<Integer> result) {
        if (root == null ) return result;
        if (root.left != null) {
            result = inorderTraversalWithList(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            result = inorderTraversalWithList(root.right, result);
        }
        return result;
    }

    /**
     * 使用栈的方式来处理
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
