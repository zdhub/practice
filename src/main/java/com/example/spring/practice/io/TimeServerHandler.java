package com.example.spring.practice.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName TimeServerHandler
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/28
 **/
public class TimeServerHandler implements Runnable {
    private Socket socket;
    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while (true) {
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("The time server receive order : " + body);
                if("QUERY TIME ORDER ".equalsIgnoreCase(body)){
                    currentTime = new Date(System.currentTimeMillis()).toString();
                } else {
                    currentTime = "BAD ORDER";
                }
                out.println(currentTime);
            }
        } catch (IOException e) {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null){
                out.close();
                out = null;
            }
            if (this.socket != null){
                try {
                    this.socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
