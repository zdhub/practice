package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution98
 * @Descirption 我首先使用了先序遍历，然后判断先序遍历的结果是不值递增的。时间复杂度比较高。
 * @Author yizhendong
 * @Date 5/1/2020
 **/
public class Solution98 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        firstOrder(list, current);
        return isValidList(list);
    }
    public void firstOrder(List<Integer> list, TreeNode current){
        if(current == null) return;
        if(current.left == null) {
            list.add(current.val);
            firstOrder(list, current.right);
        } else {
            firstOrder(list, current.left);
            list.add(current.val);
            firstOrder(list, current.right);
        }
    }

    public boolean isValidList(List<Integer> list) {
        if(list == null || list.size() <= 1){
            return true;
        }
        for(int i = 0;i<list.size() -1 ;i++){
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
