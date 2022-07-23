package sort;

/**
 * @Description:堆排序
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/14 23:22
 */
public class HeapSort {
    public static void main(String[] args) {

    }

    /**
     * 比较难理解，但是总体思想是首先循环建立初始堆，然后进行n-1次循环，将最大元素沉到数组末端，
     * 重新调整结构，满足堆的定义，继续交换，完成堆排序
     */
    public void sort(int[] nums) {
        //构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        //调整堆结构，交换堆顶元素和末尾元素
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void adjustHeap(int[] nums, int i, int length) {
        //先取出当前元素i
        int temp = nums[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k++) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else break;
        }
        //将temp值放到最终的位置
        nums[i] = temp;
    }
}
