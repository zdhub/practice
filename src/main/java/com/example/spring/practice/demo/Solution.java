package com.example.spring.practice.demo;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode MergeTwoTree(TreeNode a, TreeNode b){
        if (a == null) return b;
        if (b == null) return a;
        TreeNode temp = new TreeNode();
        temp.val = a.val + b.val;
        temp.left = MergeTwoTree(a.left, b.left);
        temp.right = MergeTwoTree(a.right, b.right);
        return temp;
    }

    public void test() {
        TreeNode a = new Solution.TreeNode();
        a.val = 1;
        TreeNode a1 = new Solution.TreeNode();
        a1.val = 2;
        a.left = a1;
        TreeNode a2 = new Solution.TreeNode();
        a2.val = 3;
        a.right = a2;

        TreeNode b = new Solution.TreeNode();
        b.val = 4;
        TreeNode b1 = new Solution.TreeNode();
        b1.val = 5;
        b.left = b1;
        TreeNode b2 = new Solution.TreeNode();
        b2.val = 6;
        b.right = b2;

        Solution s = new Solution();
        TreeNode newTreeNode = s.MergeTwoTree(a, b);
        s.printTree(newTreeNode);
    }

    public void printTree(TreeNode root){
        if (root == null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();
    }

}

