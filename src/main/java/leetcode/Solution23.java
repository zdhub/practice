package leetcode;


/**
 * @ClassName Solution23
 * @Descirption 合并K个排序链表
 * @Author yizhendong
 * @Date 2019/5/15
 **/
@Hard
public class Solution23 {
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

        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = l1;
        listNodes[1] = r1;
        ListNode head = mergeKLists(listNodes);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return getLists(lists[0], lists[1]);
        ListNode[] start = new ListNode[(lists.length+1)/2];
        ListNode[] end = new ListNode[lists.length - start.length];
        for (int i = 0;i<start.length;i++){
            start[i] = lists[i];
        }
        ListNode startNode = mergeKLists(start);
        for (int i = 0;i<end.length;i++){
            end[i] = lists[i+start.length];
        }
        ListNode endNode = mergeKLists(end);

        return getLists(startNode, endNode);
    }

    private static ListNode getLists(ListNode l1, ListNode l2) {
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
