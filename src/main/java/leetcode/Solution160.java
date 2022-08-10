package leetcode;

/**
 * @Description: Get the First Common Node in Two Lists
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/10
 * @Time:21:33
 */
@Easy
public class Solution160 {
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

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
