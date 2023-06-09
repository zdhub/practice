package leetcode;

import com.example.spring.practice.Solution;

@Easy
/**
 * Remove the duplicated node from the list
 * 也可以通过快慢指针来处理
 */
public class Solution83 {
    public Solution2.ListNode deleteDuplicates(Solution2.ListNode head) {
        Solution2.ListNode result = head;
        if (head == null || head.next == null) return head;
        while (head.next != null) {
            if (head.val != head.next.val) {
                head = head.next;
            } else {
                Solution2.ListNode next = head.next.next;
                head.next = next;
            }
        }
        return result;
    }

    public Solution2.ListNode deleteDuplicates2(Solution2.ListNode head) {
        if (head == null || head.next == null) return head;
        Solution2.ListNode slow = head;
        Solution2.ListNode fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
