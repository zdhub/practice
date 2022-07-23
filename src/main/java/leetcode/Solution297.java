package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: Encode and Decode a tree
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/16
 * @Time:11:43
 * 我使用了比较负责的解法，即将树的先序遍历和中序遍历后的数组保存，作为序列化；而反序列化的时候，再依次拆分先序遍历和中序遍历
 * 但是有一种比较简单的解法
 */
@Hard
public class Solution297 {

    public String serializeV2(TreeNode root){
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("X").append(",");
        } else {
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public TreeNode deserializeV2(String data){
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    public TreeNode buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if (val.equals("X")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> preorderList = new LinkedList<>();
        List<Integer> inorderList = new LinkedList<>();
        preorder(root, preorderList);
        inorder(root, inorderList);
        String result = genSerStr(preorderList, inorderList);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] preorder = transformPreList(data);
        int[] inorder = transformInList(data);
        return genTree(preorder, inorder);
    }

    public TreeNode genTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        TreeNode node = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return node;
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int index = 0;
        while (preorder[preStart] != inorder[inStart + index]) {
            index++;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        node.left = helper(preorder, preStart + 1, preStart + index, inorder, inStart, inStart + index - 1);
        node.right = helper(preorder, preStart + index + 1, preEnd, inorder, inStart + index + 1, inEnd);
        return node;
    }

    public int[] transformPreList(String data) {
        if (data == null || data == "") return null;
        String[] strs = data.split(":");
        if (strs.length != 2) {
            return null;
        }
        String[] numbers = strs[0].split(",");
        int[] numbersInt = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersInt[i] = Integer.parseInt(numbers[i]);
        }
        return numbersInt;
    }

    public int[] transformInList(String data) {
        if (data == null || data == "") return null;
        String[] strs = data.split(":");
        if (strs.length != 2) {
            return null;
        }
        String[] numbers = strs[1].split(",");
        int[] numbersInt = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersInt[i] = Integer.parseInt(numbers[i]);
        }
        return numbersInt;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left != null) preorder(root.left, list);
        if (root.right != null) preorder(root.right, list);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) inorder(root.left, list);
        list.add(root.val);
        if (root.right != null) inorder(root.right, list);
    }

    public String genSerStr(List<Integer> pre, List<Integer> in) {
        if (pre == null || in == null || pre.size() == 0 || in.size() == 0) {
            return "";
        }
        String numberPreString = pre.stream().map(String::valueOf).collect(Collectors.joining(","));
        String numberInString = in.stream().map(String::valueOf).collect(Collectors.joining(","));
        return numberPreString + ":" + numberInString;
    }

    public static void main(String[] args) {
        Solution297 ser = new Solution297();
        Solution297 deser = new Solution297();
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node4;
        node4.left = node3;
        String sr = ser.serialize(root);
        System.out.println(sr);
        TreeNode ans = deser.deserialize(ser.serialize(root));
        String sr1 = ser.serialize(ans);
        System.out.println(sr1);

        System.out.println(sameTree(root, ans));
    }

    public static boolean sameTree(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null) return false;
        if (node1 != null && node2 == null) return false;
        if (node1.val != node2.val) return false;
        return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
