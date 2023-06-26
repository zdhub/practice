package coding;

import leetcode.Medium;

/**
 * @Description: Convert a BSTree to a Double-Linked List
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/18
 * @Time:21:38
 * Same with LeetCode 426(block) & LintCode 1534
 * Need to review
 */

@Medium
public class Question64 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    TreeNode first = null;
    TreeNode last = null;
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }

    // 1. init the first and last node with null
    // 2. Call the in order function
    //   2.1 if the node is not null
    //      2.1.1 call the helper function recursively with node's left
    //      2.1.2 check whether the last node is null
    //      2.1.3 if it is null, then connect the node with last node
    //      2.1.4 else init the first node
    //      2.1.5 set the last with the node
    //      2.1.6 call the helper function recursively with node's right

    public void helper(TreeNode root){
        if(root != null){
            helper(root.left);
            if(last != null){
                last.right = root;
                root.left = last;
            } else {
                first = root;
            }
            last = root;
            helper(root.right);
        }
    }
}
