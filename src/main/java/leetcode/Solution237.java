package leetcode;

@Easy
public class Solution237 {
    public static void deleteNode(Solution2.ListNode node){
        Solution2.ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
