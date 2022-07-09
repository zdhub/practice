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
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val = 0;
            if (l1 != null) {
                val = val + l1.val;
            }
            if (l2 != null) {
                val = val + l2.val;
            }
            if (carry != 0) {
                val = val + carry;
            }
            ListNode node = new ListNode(val % 10);
            carry = (val) / 10;
            current.next = node;
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode head = solution2.generateList();
        ListNode reverseNode = solution2.reverse(head);
        while (reverseNode != null){
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode current = new ListNode(0);
        ListNode head = current;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val = 0;
            if(l1 != null) val += l1.val;
            if(l2 != null) val += l2.val;
            if(carry != 0) val += carry;
            if(val >= 10){
                carry = 1;
                val -= 10;
            }
            ListNode node = new ListNode(val);
            current.next = node;
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }

    public ListNode generateList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        return node1;
    }

    public ListNode reverse(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
