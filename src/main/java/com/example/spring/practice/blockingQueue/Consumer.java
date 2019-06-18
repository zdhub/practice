package com.example.spring.practice.blockingQueue;

import sun.security.provider.NativePRNG;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName Consumer
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/19
 **/
public class Consumer implements Runnable {
    private BlockingQueue<String> stock;
    private String consumerName;
    public Consumer(BlockingQueue<String> stock, String consumerName){
        this.stock = stock;
        this.consumerName = consumerName;
    }
    @Override
    public void run() {
        while (true) {
            try {
                String name = stock.take();
                System.out.println("正在消费数据" + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
