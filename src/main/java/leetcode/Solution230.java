package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description: Kth Smallest Element in a BST
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/10
 * @Time:23:11
 * @Comment: 有两种解法，第一种就是利用递归，按照中序遍历，构造一个数组，返回数组的第K个数，时间复杂度O(n);
 * 还有一种解法，利用栈，进行迭代中序遍历，可以降低时间复杂度为O(n/2)
 */
@Medium
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallestV2(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
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
