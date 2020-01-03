package leetcode;

import java.util.*;

/**
 * @Description:给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/11/19 23:57
 */
@Medium
public class Solution347 {
    public static void main(String[] args) {
        int[] num = {4,1,-1,2,-1,2,3};
        Solution347 solution347 = new Solution347();
        solution347.topKFrequent(num, 2).stream().forEach(System.out::println);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0 || k <= 0) return new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> list = new PriorityQueue<Map.Entry<Integer, Integer>>(k, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (list.size() < k) {
                list.add(entry);
            } else {
                if (entry.getValue() > list.peek().getValue()) {
                    list.poll();
                    list.add(entry);
                } else continue;
            }
        }

        List<Integer> result = new ArrayList<>();
        int num = list.size();
        for (int i = 0; i < num; i++) {
            result.add(list.poll().getKey());
        }

        return result;
    }
}
