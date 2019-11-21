package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description:根据身高重建队列
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/21 23:28
 */
@Medium
public class Solution407 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution407 solution407 = new Solution407();
        Arrays.stream(solution407.reconstructQueue(people)).forEach(ints -> System.out.println(ints[0] + "" + ints[1]));
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i: people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
