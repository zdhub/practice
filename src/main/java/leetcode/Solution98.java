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
        middleOrder(list, current);
        return isValidList(list);
    }

    public void middleOrder(List<Integer> list, TreeNode current) {
        if (current == null) return;
        if (current.left == null) {
            list.add(current.val);
            middleOrder(list, current.right);
        } else {
            middleOrder(list, current.left);
            list.add(current.val);
            middleOrder(list, current.right);
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
