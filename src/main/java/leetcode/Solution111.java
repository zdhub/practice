package leetcode;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */

@Easy
public class Solution111 {
    public int depth = 0;
    public int minDepth(Solution102.TreeNode root) {
        if (root == null) return depth;
        LinkedList<Solution102.TreeNode> q = new LinkedList<>();
        q.offer(root);
        depth++;
        while(q.size() != 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Solution102.TreeNode node = q.poll();
                if (node.left == null && node.right == null){
                    return depth;
                }
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
