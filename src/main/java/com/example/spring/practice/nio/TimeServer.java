package com.example.spring.practice.nio;

/**
 * @ClassName TimeServer
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/28
 **/
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimerServer timeServer = new MultiplexerTimerServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
