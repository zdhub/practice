package leetcode;

/**
 * @Description: Get the First Common Node in Two Lists
 * 可以使用双指针方法，非常巧妙，代码也很简洁
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/10
 * @Time:21:33
 */
@Easy
public class Solution160 {
    ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode na = headA;
        ListNode nb = headB;
        while(na != null){
            lengthA++;
            na = na.next;
        }
        while(nb != null){
            lengthB++;
            nb = nb.next;
        }
        int gap = lengthB - lengthA;
        ListNode longList = headB;
        ListNode shortList = headA;
        if(lengthA > lengthB){
            gap = lengthA - lengthB;
            longList = headA;
            shortList = headB;
        }

        while(gap != 0){
            longList = longList.next;
            gap--;
        }

        while(longList != null && shortList != null){
            if(longList == shortList) return longList;
            else{
                longList = longList.next;
                shortList = shortList.next;
            }
        }
        return null;

    }
}
