package demo;

public class Solution {
    public static void main(String[] args) {

    }

    public static int LengthOfTwoNodeInOneTree(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) {
            return -1;
        }
        TreeNode commonParent = FindCommonParent(root, a, b);
        int length1 = FindShortestLength(commonParent, a, 0);
        int length2 = FindShortestLength(commonParent, b, 0);
        return length1 + length2;
    }

    private static int FindShortestLength(TreeNode root, TreeNode a, int lengthOld) {
        // TODO add skip check with global var
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.val == a.val) {
            return 0;
        }
        return Math.min(FindShortestLength(root.left, a, lengthOld + 1),
                FindShortestLength(root.right, a, lengthOld + 1));
    }

    private static TreeNode FindCommonParent(TreeNode root, TreeNode a, TreeNode b) {
        boolean isParent = IsParentWithTwoNode(root, a, b);
        if (!isParent) {
            return null;
        }
        if ((!IsParentWithTwoNode(root.left, a, b)) && !IsParentWithTwoNode(root.right, a, b)) {
            return root;
        }
        if (IsParentWithTwoNode(root.left, a, b)) {
            return FindCommonParent(root.left, a, b);
        }
        return FindCommonParent(root.right, a, b);
    }

    private static boolean IsParentWithTwoNode(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return false;
        }
        if (!IsParent(root, a)) {
            return false;
        }
        if (!IsParent(root, b)) {
            return false;
        }
        return true;
    }

    private static boolean IsParent(TreeNode root, TreeNode a) {
        if (root == null) {
            return false;
        }
        if (root.val == a.val) {
            return true;
        }
        return IsParent(root.left, a) || IsParent(root.right, a);
    }
}
