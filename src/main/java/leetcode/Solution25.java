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
