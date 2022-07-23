package leetcode;

@Easy
/**
 * Remove the duplicated node from the list
 */
public class Solution83 {
    public Solution2.ListNode deleteDuplicates(Solution2.ListNode head) {
        Solution2.ListNode result = head;
        if (head == null || head.next == null) return head;
        while(head.next != null){
            if(head.val != head.next.val){
                head = head.next;
            } else {
                Solution2.ListNode next = head.next.next;
                head.next = next;
            }
        }
        return result;
    }
}
