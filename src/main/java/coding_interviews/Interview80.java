package coding_interviews;

import leetcode.Easy;

import java.util.HashMap;

/**
 * @Description: An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * @Version:1.0
 * @Author:yizhendong
 * @Date:2022/8/7
 * @Time:18:05
 */
@Easy
public class Interview80 {
    public boolean isAnagram(String s, String t) {
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i = 0;i <s.length(); i++){
            Character ch = s.charAt(i);
            if(charMap.containsKey(ch)){
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        for(int j = 0; j < t.length(); j++){
            Character ch = t.charAt(j);
            if(!charMap.containsKey(ch)){
                return false;
            }
            if(charMap.get(ch) == 0){
                return false;
            }
            charMap.put(ch, charMap.get(ch) - 1);
        }
        return true;
    }
}
