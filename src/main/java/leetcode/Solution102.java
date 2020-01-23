package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution102
 * @Descirption 二叉树的层次遍历 也是有两种方法，递归和迭代。第一次没有想出来做法，看了提示之后才想到
 * @Author yizhendong
 * @Date 5/1/2020
 **/
@Medium
public class Solution102 {
    public static void main(String[] args) {

    }

    /**
     * 第一种方法：递归
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper(result, root, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(result, root.left, level + 1);
        }
        if (root.right != null) {
            helper(result, root.right, level + 1);
        }
    }

    /**
     * 第二种方法：迭代
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        return null;
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
