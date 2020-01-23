package leetcode;

/**
 * @ClassName Solution2
 * @Descirption 两数相加
 * @Author yizhendong
 * @Date 23/1/2020
 **/
@Medium
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode current = new ListNode(0);
        ListNode head = current;
        int pre = 0;
        while (l1 != null || l2 != null || pre != 0) {
            int val = 0;
            if (l1 != null) {
                val = val + l1.val;
            }
            if (l2 != null) {
                val = val + l2.val;
            }
            if (pre != 0) {
                val = val + pre;
            }
            ListNode node = new ListNode(val % 10);
            pre = (val) / 10;
            current.next = node;
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
