package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution23
 * @Descirption 合并K个排序链表。分而治之的方法的时间复杂度为：O(Nlogk)，其中k 是链表的数目，N是总的节点数目。时间复杂度较优
 * 2023年的思路，可以使用优先级队列来说实现
 * @Author yizhendong
 * @Date 2019/5/15
 **/
@Hard
public class Solution23 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l4;

        ListNode r1 = new ListNode(1);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        r1.next = r3;
        r3.next = r4;

        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = l1;
        listNodes[1] = r1;
        ListNode head = mergeKLists1(listNodes);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return getLists(lists[0], lists[1]);
        ListNode[] start = new ListNode[(lists.length + 1) / 2];
        ListNode[] end = new ListNode[lists.length - start.length];
        for (int i = 0; i < start.length; i++) {
            start[i] = lists[i];
        }
        ListNode startNode = mergeKLists(start);
        for (int i = 0; i < end.length; i++) {
            end[i] = lists[i + start.length];
        }
        ListNode endNode = mergeKLists(end);

        return getLists(startNode, endNode);
    }

    public static ListNode mergeKListsV2(ListNode[] lists){
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for (ListNode head : lists) {
            pq.add(head);
        }
        ListNode head = new ListNode(1);
        ListNode dummy = head;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            head = head.next;
        }
        return dummy.next;
    }

    private static ListNode getLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        head.next = l1.val < l2.val ? l1 : l2;
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else cur.next = l2;
        return head.next;
    }

    private static ListNode mergeKLists1(ListNode[] lists) {
        return mergeKListsFromStactAndEnd(lists, 0, lists.length - 1);
    }

    private static ListNode getListsFrom2List(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode root = new ListNode(1);
        ListNode result = new ListNode(1);
        result.next = root;
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        while (cur1 != null && cur2 != null) {
            ListNode temp = new ListNode(0);
            if (cur1.val < cur2.val) {
                temp.val = cur1.val;
                cur1 = cur1.next;
            } else {
                temp.val = cur2.val;
                cur2 = cur2.next;
            }
            root.next = temp;
            root = root.next;
        }
        root.next = cur1 == null ? cur2 : cur1;
        return result.next.next;
    }

    private static ListNode mergeKListsFromStactAndEnd(ListNode[] lists, int start, int end) {
        if (lists == null || lists.length == 0) return null;
        if (start >= end) return lists[start];
        int mid = (start + end) / 2;
        return getListsFrom2List(mergeKListsFromStactAndEnd(lists, start, mid), mergeKListsFromStactAndEnd(lists, mid + 1, end));
    }

    private ListNode mergeKListsByQueue(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode listNode : lists) {
            if (listNode != null) queue.add(listNode);
        }

        while (!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
