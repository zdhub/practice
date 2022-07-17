package coding_interviews;

/**
 * @Description:Verify a Post-Order Traversal Sequence
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/7/17
 * @Time:17:00
 */
public class Question63 {
    public boolean VerifySequenceOfBST(int[] postOrder) {
        if (postOrder == null || postOrder.length <= 0) return false;
        int leftIndex = 0;
        int rightIndex = postOrder.length - 1;
        return VerifyCore(postOrder, leftIndex, rightIndex);
    }

    private boolean VerifyCore(int[] postOrder, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return true;
        int middleIndex = leftIndex;
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (postOrder[i] < postOrder[rightIndex]) continue;
            else {
                middleIndex = i;
                break;
            }
        }
        for (int j = middleIndex; j < rightIndex; j++) {
            if (postOrder[j] > postOrder[rightIndex]) continue;
            else return false;
        }
        return VerifyCore(postOrder, leftIndex, middleIndex - 1) && VerifyCore(postOrder, middleIndex + 1, rightIndex - 1);
    }

    public static void main(String[] args) {
        int[] number = new int[]{5, 7, 6, 9, 11, 10, 8};
        Question63 question63 = new Question63();
        System.out.println(question63.VerifySequenceOfBST(number));
        number = new int[]{7, 4, 6, 5};
        System.out.println(question63.VerifySequenceOfBST(number));
    }
}
