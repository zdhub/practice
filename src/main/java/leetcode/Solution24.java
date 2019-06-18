package leetcode;

/**
 * @ClassName Solution24
 * @Descirption  两两交换链表中的节点 使用递归方法非常简单。。
 * @Author yizhendong
 * @Date 2019/5/15
 **/
@Medium
@TriedButFaild
public class Solution24 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next =l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = swapPairs(l1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode newSecond = second;
        ListNode newFirst = first;
        int i = 1;
        while (head != null){
            ListNode item = new ListNode(head.val);
            if (i%2 == 1){
                first.next = item;
                first = first.next;
            }else {
                second.next = item;
                second = second.next;
            }
            i++;
            head = head.next;
        }
        ListNode result = mergeLists(newFirst.next, newSecond.next);
        return result;
    }

    private static ListNode mergeLists(ListNode newFirst, ListNode newSecond) {
        ListNode newResult = new ListNode(0);
        ListNode result = newResult;
        while (newFirst != null && newSecond != null){
            ListNode itemSecond = new ListNode(newSecond.val);
            newResult.next = itemSecond;
            newSecond = newSecond.next;
            newResult = newResult.next;
            ListNode itemFirst = new ListNode(newFirst.val);
            newResult.next = itemFirst;
            newFirst = newFirst.next;
        }
        if (newFirst != null){
            ListNode itemFirst = new ListNode(newFirst.val);
            newResult = newResult.next;
            newResult.next = itemFirst;
        }
        return result;
    }

    public ListNode otherSwapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

}
