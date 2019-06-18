package com.example.spring.practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Descirption
 * @Author yizhendong
 * @Date 2019/2/25
 **/
class LRUCache extends LinkedHashMap {
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(final int maxSize) {
        cache = new LinkedHashMap<Integer, Integer>(16, .75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > maxSize;
            }
        };
    }

    public int get(int key) {
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        String[] strings = {"123", "12", "1"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        String result = "";
        if (strs == null) {
            return result;
        }
        if (strs.length < 1) {
            return result;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs.length; i++) {
            int tempLen = strs[i].length();
            if (tempLen > minLen) {
                continue;
            } else {
                minLen = tempLen;
            }
        }
        if (minLen == 0) {
            return result;
        }
        for (int i = 1; i <= minLen; i++) {
            String str = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(str)) {
                    return result;
                }
            }
            result = str;
        }
        return result;
    }

}
