package coding;

public class Interview3 {
    // duplicate returns -1 when there is no duplicated number or the parameter is invalid.
    public static int duplicate(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < 0 || arrays[i] >= arrays.length) {
                return -1;
            }
        }

        for (int i = 0; i < arrays.length; i++) {
            while (i != arrays[i]) {
                if (arrays[i] == arrays[arrays[i]]) {
                    return arrays[i];
                }
                // swap the arrays[i] and arrays[arrays[i]]
                int temp = arrays[i];
                arrays[i] = arrays[arrays[i]];
                arrays[temp] = temp;
            }
        }
        return -1;
    }

    // 第二种题，不修改数组找出重复的数字:用时间复杂度为O(nlogn)，空间复杂度为1
    public static int duplicate1(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arrays.length - 1;
        while (start <= end) {
            int middle = (end - start + 1)/2 + start;
            int count = getCount(arrays, start, middle);
            if (end == start) {
                if (count >= 1){
                    return arrays[end];
                }else {
                    return -1;
                }
            }
            if (count > middle - start + 1){
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int getCount(int[] arrays, int start, int end){
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] >= start && arrays[end] <= end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 3, 4, 5, 6, 1, 3};
        int duplicate;
        duplicate = duplicate(arrays);
        System.out.println(duplicate);

        duplicate = duplicate1(arrays);
        System.out.println(duplicate);
    }
}
