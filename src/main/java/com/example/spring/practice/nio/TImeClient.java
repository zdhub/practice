package com.example.spring.practice.nio;

/**
 * @ClassName TImeClient
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/28
 **/
public class TImeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}
