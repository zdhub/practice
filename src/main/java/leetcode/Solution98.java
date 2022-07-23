package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution98
 * @Descirption 我首先使用了中序遍历，然后判断中序遍历的结果是不值递增的。时间复杂度比较高。
 * @Author yizhendong
 * @Date 5/1/2020
 **/
public class Solution98 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        inOrder(list, current);
        return isValidList(list);
    }

    public void inOrder(List<Integer> list, TreeNode current) {
        if (current == null) return;
        if (current.left == null) {
            list.add(current.val);
            inOrder(list, current.right);
        } else {
            inOrder(list, current.left);
            list.add(current.val);
            inOrder(list, current.right);
        }
    }

    public boolean isValidList(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    /**
     * 也可以使用栈
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public boolean isValidBSTV2(TreeNode root) {
        Integer min = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return true;
        while (root != null || stack.isEmpty() == false) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= min) return false;
            min = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 也可以使用递归
     * 可以想象判断一个数的值是否都在一个上下限之内，如果是的话，依次判断这个树的左子树和右子树
     */
    public boolean isValidBSTV3(TreeNode root){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if (root == null) {
            return true;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean helper(TreeNode root, int min, int max){
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    /**
     * 还有一种很巧妙的方法，使用中序遍历，一边遍历，一边判断当前的值是否比前一个值小，如果是的话，return false
     */
    Integer pre = Integer.MIN_VALUE;
    public boolean isValidBSTV4(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBSTV4(root.left)){
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val < pre) {
            return false;
        }
        pre = root.val;
        return isValidBSTV4(root.right);
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
