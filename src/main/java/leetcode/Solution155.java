package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 第一次用的是list加stack的方法，时间效率很低。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/15 8:50
 * 2022年7月12日，再一次做没有成功想出来。
 * 看了讨论之后，发现思路大概有两种，一种是通过两个栈来处理，一个栈保留原始的数字，另外一个栈保留历史最小值；
 * 还有一种思路是通过链表的节点来处理，节点的元素包括值val，以及最小值min，以及next节点。
 */
class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
    }

    private Node head;

    public void push(int x){
        if (head == null){
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }

    public void pop(){
        head = head.next;
    }

    public int getMin(){
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }


}
