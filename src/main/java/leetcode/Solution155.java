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
 */
class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
    }
    private Stack<Integer> stack;
    private List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (list.size() == 0) {
            list.add(x);
        } else {
            listAdd(x);
        }
    }

    private void listAdd(int x) {
        if (list.size() == 0) {
            list.add(x);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (x < list.get(i)) {
                    list.add(i, x);
                    return;
                }
            }
            list.add(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        removeList(x);
    }

    private void removeList(int x) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i)) {
                index = i;
                break;
            }
        }
        list.remove(index);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(0);
    }
}
