package com.example.spring.practice.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TimeServer
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/28
 **/
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is started in port : " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if(server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
