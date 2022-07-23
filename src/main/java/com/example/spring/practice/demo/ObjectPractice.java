package com.example.spring.practice.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ObjectPractice
 * @Descirption
 * @Author yizhendong
 * @Date 14/11/2019
 **/
@Setter
@Getter
public class ObjectPractice implements Cloneable {
    private String type;
    private ObjectPractice inner;

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) {
        waitNotifyCase();
    }

    private static void waitNotifyCase() {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread B is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread B get lock");
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("thread B do wait method");
                        lock.notify();
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("thread B do nofity method");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void cloneTest() {
        ObjectPractice practice = new ObjectPractice();
        practice.setType("1");

        ObjectPractice inner = new ObjectPractice();
        inner.setType("1");

        practice.setInner(inner);

        Number n = 0.0F;
        Class<? extends Number> c = n.getClass();
        // class java.lang.Integer
        System.out.println(c);

        try {
            ObjectPractice practice1 = (ObjectPractice)practice.clone();

            practice.setInner(null);
            System.out.println(practice1.getInner().getType());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
