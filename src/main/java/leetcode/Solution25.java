package leetcode;

/**
 * @ClassName Solution25
 * @Descirption k个一组翻转链表，第二次尝试没有成功
 * @Author yizhendong
 * @Date 2019/5/15
 **/
@Hard
public class Solution25 {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroupV2(ListNode head, int k){
        if(k <= 1 || head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {

            // Firstly, check if there are k nodes to reverse.
            ListNode node = pointer;
            for (int i = 0; i < k && node != null; i++){
                node = node.next;
            }
            if (node == null) break;

            // Secondly, start from the first node.
            ListNode pre = null, cur = pointer.next, next = null;
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // 关键在这里，需要仔细体会
            ListNode tail = pointer.next;
            tail.next = cur;
            pointer.next = pre;
            pointer = tail;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current_node = head;
        int count = 0;
        while (current_node != null && count != k) {
            current_node = current_node.next;
            count++;
        }
        if (count == k) {
            current_node = reverseKGroup(current_node, k);/// 递归的解决子问题
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = current_node;
                current_node = head;
                head = temp;
            }///最终，该段的所有节点将会截空，head应指向current_node
            head = current_node;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
