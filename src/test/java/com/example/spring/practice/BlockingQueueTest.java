package com.example.spring.practice;

import org.junit.Test;
import org.springframework.boot.convert.DurationStyle;

import java.util.concurrent.*;

/**
 * @Description:
 * @vertion:1.0
 * @author:yizhendong
 * @date:2019/12/9 23:51
 */
public class BlockingQueueTest {
    @Test
    public void testQueue(){
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(3);
        blockingQueue.add("java");
        blockingQueue.add("php");
        blockingQueue.add("c++");
        try {
            blockingQueue.offer("html", 3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    @Test
    public void testThreadPool(){
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,5,300000,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(2) );
//        try {
//            poolExecutor.submit(new ThreadTest());
//            poolExecutor.submit(new ThreadTest());
//            poolExecutor.submit(new ThreadTest());
//            poolExecutor.submit(new ThreadTest());
//            poolExecutor.submit(new ThreadTest());
//            poolExecutor.submit(new ThreadTest());
//            poolExecutor.submit(new ThreadTest());
//            poolExecutor.submit(new ThreadTest());
//        } catch (Exception e) {
//            System.out.println("错误");
//            e.printStackTrace();
//        }
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(poolExecutor.getPoolSize());
//        poolExecutor.submit(new ThreadTest());
//        poolExecutor.submit(new ThreadTest());
//        poolExecutor.submit(new ThreadTest());
//        poolExecutor.submit(new ThreadTest());
//        poolExecutor.submit(new ThreadTest());
//        System.out.println(poolExecutor.getPoolSize());

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new ThreadTest(),1,1,TimeUnit.SECONDS );
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
    class ThreadTest implements Runnable{


        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
