package com.example.spring.practice.demo;

/**
 * @ClassName DeadLock
 * @Descirption
 * @Author yizhendong
 * @Date 23/7/2019
 **/
public class DeadLock {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("now is in threadA lock a");
                        Thread.sleep(1000L);
                        synchronized (b) {
                            System.out.println("now is in threadA lock b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    try {
                        System.out.println("now is in threadB lock b");
                        Thread.sleep(1000L);
                        synchronized (a) {
                            System.out.println("now is in threadA lock a");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
