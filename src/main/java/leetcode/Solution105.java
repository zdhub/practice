package leetcode;

import java.util.HashMap;

/**
 * @Description: 根据前序遍历和中序遍历构造树
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/11 20:17
 */
@Medium
public class Solution105 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return helperBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helperBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int index = 0;
        //中间这一步可以简化，因为每次都需要遍历，查询index，可以通过提前使用一个hashmap来保存值和index的对应关系
        while (inorder[inStart + index] != preorder[preStart]) {
            index++;
        }
        treeNode.left = helperBuild(preorder, preStart + 1, preStart + index, inorder, inStart, inStart + index - 1);
        treeNode.right = helperBuild(preorder, preStart + index + 1, preEnd, inorder, inStart + index + 1, inEnd);
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helperBuild2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode helperBuild2(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend, HashMap<Integer, Integer> map) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        int index = map.get(preorder[pstart]);
        int gap = index - istart;
        TreeNode node = new TreeNode(preorder[pstart]);
        node.left = helperBuild2(preorder, pstart + 1, pstart + gap, inorder, istart, istart + gap , map);
        node.right = helperBuild2(preorder, pstart + gap + 1, pend, inorder, istart + gap + 1, iend, map);
        return node;
    }
}
