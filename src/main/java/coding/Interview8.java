package coding;

import java.util.LinkedList;

public class Interview8 {

    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    // 这是我的做法，其中第一种case和第三种case里的迭代条件都是错误的
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return pNode;
        }
        if (pNode.right != null) {
            while (pNode.right.left != null) {
                pNode = pNode.right;
            }
            return pNode.left;
        }
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        if (pNode.next != null) {
            while (pNode.next != null && pNode.next.right == pNode) {
                pNode = pNode.next;
            }
            return pNode.next;
        }
        return null;
    }

    // 这是第一种标准做法，时间复杂度O(n),空间复杂度O(1)
    public TreeLinkNode GetNextSample1(TreeLinkNode pNode) {
        if (pNode == null) {
            return pNode;
        }
        if (pNode.right != null) {
            // 一直找到右子树的最左下的结点为返回值
            TreeLinkNode rchild = pNode.right;
            while (rchild.left != null) {
                rchild = rchild.left;
            }
            return rchild;
        }
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        // 沿着左上一直爬树，爬到当前结点是其父节点的左自己结点为止
        if (pNode.next != null) {
            TreeLinkNode ppar = pNode.next;
            while (ppar.next != null && ppar.next.right == ppar) {
                ppar = ppar.next;
            }
            return ppar.next;
        }
        return null;
    }


    // 还有一种比较容易理解的方法，即先中序遍历，然后从中序遍历的数组中找到下一个节点
    public TreeLinkNode GetNextSample2(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode temp = pNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        InOrder(temp);

        for (int i = 0; i < list.size() - 1; i++) {
            if (pNode.val == list.get(i).val) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    private static LinkedList<TreeLinkNode> list = new LinkedList<>();

    private void InOrder(TreeLinkNode temp) {
        if (temp.left != null) {
            InOrder(temp.left);
        }
        list.add(temp);
        if (temp.right != null) {
            InOrder(temp.right);
        }
    }

}

