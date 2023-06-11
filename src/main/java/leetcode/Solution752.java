package leetcode;

import java.util.*;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 *
 *
 * Example 1:
 *
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 *
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
 */
public class Solution752 {
    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        HashSet<String> deads = new HashSet<>();
        deads.addAll(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        Queue<String> list = new LinkedList<>();
        visited.add("0000");
        list.add("0000");
        int step = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String cur = list.poll();
                if (deads.contains(cur)){
                    continue;
                }
                if (Objects.equals(cur, target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up(cur, j);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        list.offer(up);
                    }

                    String down = down(cur, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        list.offer(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static String up(String str, int i) {
        char[] chars = str.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    public static String down(String str, int i) {
        char[] chars = str.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
}
