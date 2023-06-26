package coding;

import java.util.ArrayList;
import java.util.LinkedList;

public class Interview6 {
    private static class ListNode{
        int val;
        ListNode nextNode;
    }
    public static ListNode generateList() {
        ListNode a = new ListNode();
        a.val = 123;
        ListNode b = new ListNode();
        b.val = 234;
        ListNode c = new ListNode();
        c.val = 345;
        ListNode d = new ListNode();
        d.val = 456;
        a.nextNode = b;
        b.nextNode = c;
        c.nextNode = d;
        return a;
    }

    public static void main(String[] args) {
        ListNode old = generateList();
        ArrayList<Integer> list = PrintValueFromTailToHead(old);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("================");
        ArrayList<Integer> list2 = ReverseList(old);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }

    private static ArrayList<Integer> arrayList = new ArrayList<>();

    // 第一种方式，使用递归的方式
    public static ArrayList<Integer> PrintValueFromTailToHead(ListNode head){
        if (head.nextNode != null){
            PrintValueFromTailToHead(head.nextNode);
        }

        arrayList.add(head.val);
        return arrayList;
    }

    // 第二种方式，使用栈的方式
    public static ArrayList<Integer> ReverseList(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        if (head == null) {
            return new ArrayList<>(list);
        }
        while (head != null) {
            list.push(head.val);
            head = head.nextNode;
        }
        return new ArrayList<>(list);
    }
}
