package com.example.spring.practice.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/9/14 12:30
 */
public class LatchDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100));
        int size = 2;
        CountDownLatch latch = new CountDownLatch(size);
        for (int i = 0; i < size; i++){
            executor.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("test");
                    latch.countDown();
                }
            }));
        }

        try {
            System.out.println("this is a test");
            latch.await();
            System.out.println("test end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
