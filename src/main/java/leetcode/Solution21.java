package leetcode;


/**
 * @ClassName Solution21
 * @Descirption 合并两个有序链表
 * @Author yizhendong
 * @Date 2019/5/14
 **/
@Easy
public class Solution21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l1.next =l2;
        l2.next = l4;

        ListNode r1 = new ListNode(1);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        r1.next = r3;
        r3.next = r4;
        ListNode head = mergeTwoLists(l1, r1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        head.next = l1.val < l2.val ? l1 : l2;
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        } else cur.next = l2;
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


}
