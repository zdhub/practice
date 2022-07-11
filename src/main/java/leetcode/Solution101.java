package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution101
 * @Descirption
 * @Author yizhendong
 * @Date 5/1/2020
 * 2022年7月11日，重新做又一次性做对；迭代的方式也很优雅，第一次没有想到；
 **/
@Easy
public class Solution101 {

    /**
     * 这个方法有问题 当输入的树是[1,2,2,2,null,2]时，预期为false，但是这个方式返回的是true
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        middleOrder(root, list);
        return isSymmetricList(list);
    }

    private boolean isSymmetricList(ArrayList<Integer> list) {
        if (list == null || list.size() <= 1) return true;
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;

    }

    private void middleOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        middleOrder(root.left, list);
        list.add(root.val);
        middleOrder(root.right, list);

    }

    /**
     * 使用递归的方式
     */
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left.val != right.val) return false;
        if (left == null && right == null) return true;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    /**
     * 使用迭代的方式,时间复杂度和空间复杂度都是O(N)
     */
    public boolean isSymmetricV3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() != 0) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t2.left);
            queue.add(t1.right);
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
