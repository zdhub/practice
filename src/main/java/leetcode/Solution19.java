package leetcode;

/**
 * @ClassName Solution19
 * @Descirption  删除链表的倒数第N个节点 medium https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @Author yizhendong
 * @Date 2019/5/13
 **/
@Medium
public class Solution19 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode head = removeNthFromEnd(l1, 1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode r = head;
        for (int i = 1;i<n;i++){
            r = r.next;
        }
        ListNode l = dummyNode;
        while (r.next != null){
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummyNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

}
