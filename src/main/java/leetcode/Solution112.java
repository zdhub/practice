package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: Path Sum. 虽然思考了一会儿，然是仍旧一次作对，使用方法为递归
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/14
 * @Time:23:40
 */
@Easy
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        List<Integer> list = new LinkedList<>();
        while(root != null){
            if(targetSum == root.val && root.left == null && root.right == null) return true;
            int target = targetSum - root.val;
            return hasPathSum(root.left, target) || hasPathSum(root.right, target);
        }
        return false;
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
