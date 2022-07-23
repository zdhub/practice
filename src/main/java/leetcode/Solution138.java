package leetcode;

/**
 * 有一个链表，除了next属性以外，还有random属性，给定链表，对该链表进行复制，然后返回复制后的链表
 * 有思路，而且基本可以编写正确
 */

@Medium
public class Solution138 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node originNode = head;
        if (head == null) return null;
        while (originNode != null) {
            Node cloneNode = new Node(originNode.val);
            Node next = originNode.next;
            originNode.next = cloneNode;
            cloneNode.next = next;
            originNode = next;
        }
        Node newHead = head;
        Node secondHead = head.next;
        Node result = secondHead;
        while (head != null) {
            Node originRandom = head.random;
            Node newNode = head.next;
            if (originRandom != null) {
                newNode.random = originRandom.next;
            } else {
                newNode.random = null;
            }
            head = newNode.next;
        }

        while (newHead != null) {
            newHead.next = newHead.next.next;
            if (secondHead.next != null) {
                secondHead.next = secondHead.next.next;
            } else {
                secondHead.next = null;
                break;
            }
            newHead = newHead.next;
            secondHead = secondHead.next;
        }
        return result;
    }
}
