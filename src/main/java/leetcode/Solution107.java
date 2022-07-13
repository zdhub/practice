package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 102题的相似版本，但是输出的是从底向上
 * @vertion:1.0
 * @author:yizhendong
 * @date:2022/7/13
 * @time:23:03
 */
public class Solution107 {
    public List<List<Integer>> levelOrder1(Solution102.TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Solution102.TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.offer(root);
        while(queue.size() != 0){
            int levelNum = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            // 唯一的不同就是这里
            list.add(0, sublist);
        }
        return list;
    }

    /**
     * 第一种方法：递归，或者称之为深度优先 DFS
     */
    public List<List<Integer>> levelOrder(Solution102.TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        helper(result, root, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, Solution102.TreeNode root, int level) {
        if (root == null) return;
        if (level >= result.size()) {
            result.add(0, new LinkedList<>());
        }
        helper(result, root.left, level + 1);
        helper(result, root.right, level + 1);
        result.get(result.size() - level - 1).add(root.val);
    }

    public class TreeNode {
        int val;
        Solution102.TreeNode left;
        Solution102.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
