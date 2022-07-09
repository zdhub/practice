package coding_interviews;

public class Question45 {

    public static void main(String[] args) {
        int[] arrays = new int[]{1,4,5,6,9};
        ReorderArray(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
    public static void ReorderArray(int[] array){
        if (array == null || array.length <2) return;
        int leftIndex = 0;
        int rightIndex = array.length -1;
        while (leftIndex < rightIndex) {
            while (IsEvens(array[leftIndex])) {
                leftIndex++;
            }
            while (!IsEvens(array[rightIndex])) {
                rightIndex--;
            }
            if (leftIndex < rightIndex){
                swap(array, leftIndex, rightIndex);
            }
            leftIndex++;
            rightIndex--;
        }
    }

    //判断是否是偶数
    public static boolean IsEvens(int number) {
        return number % 2 == 0;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
