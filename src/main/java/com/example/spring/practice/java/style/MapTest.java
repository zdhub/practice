package com.example.spring.practice.java.style;

import org.springframework.util.StopWatch;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MapTest
 * @Descirption
 * @Author yizhendong
 * @Date 2019/4/5
 **/
public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start("map1");
        for (int i = 0;i<10000;i++){
            map.put(String.valueOf(i), String.valueOf(i));
        }
        stopWatch1.stop();
        System.out.println(stopWatch1.getLastTaskName() + ":" + stopWatch1.getTotalTimeMillis());

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("map2");
        ConcurrentHashMap<String, String> testMap = new ConcurrentHashMap<>(10000);
        for (int i = 0;i<10000;i++){
            testMap.put(String.valueOf(i), String.valueOf(i));
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskName() + ":" + stopWatch.getTotalTimeMillis());

    }
}
