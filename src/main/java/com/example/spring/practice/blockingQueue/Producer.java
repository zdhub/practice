package com.example.spring.practice.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName Producer
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/19
 **/
public class Producer implements Runnable{
    private BlockingQueue<String> stock;
    private String producerName;

    public Producer(BlockingQueue<String> blockingQueueProducer, String producerName){
        this.stock = blockingQueueProducer;
        this.producerName = producerName;
    }

    @Override
    public void run() {
        while (true){
            try {
                stock.put(producerName);
                System.out.println("正在生产数据" + producerName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
