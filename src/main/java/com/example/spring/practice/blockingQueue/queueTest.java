package com.example.spring.practice.blockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName queueTest
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/19
 **/
public class queueTest {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {

//        BlockingQueue<String> stock = new ArrayBlockingQueue<>(10);
//        Thread p1 = new Thread(new Producer(stock,  "Mac"));
//        Thread p2 = new Thread(new Producer(stock,  "Dell"));
//        Thread c1 = new Thread(new Consumer(stock,"zhangsan"));
//        Thread c2 = new Thread(new Consumer(stock, "李四"));
//
//        p1.start();
//        p2.start();
//        c1.start();
//        c2.start();
//        getList();
//        testSync();
        while (true){
            System.out.println("test");
        }
    }

    private static void testSync() {
//        List<String> list = new ArrayList<>();
//        for (int i = 0;i<10;i++){
//            list.add("" + i);
//        }
//        Task task = new Task(list);
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                task.moveJob();
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                task.printJob();
//            }
//        });
//        thread1.start();
//        thread2.start();
    }

    public static void test(){

    }

    public static void getList(){
        ArrayList<String> list = new ArrayList();
        for (int i = 0;i<10;i++){
            list.add(i+"");
            list.add(i+"");
        }
        list.remove("1");
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        Callable<Integer> callable1 = new ListCheck("1",list);
        Callable<Integer> callable2 = new ListCheck("1",list);
        Future<Integer> result1 = executor.submit(callable1);
        Future<Integer> result2 = executor.submit(callable2);
        while (executor.isShutdown()){
            if (result1.isDone()){
                try {
                    System.out.println(result1.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            if (result2.isDone()){
                try {
                    System.out.println(result2.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
