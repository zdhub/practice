package com.example.spring.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName WechatTest
 * @Descirption
 * @Author yizhendong
 * @Date 2019/4/12
 **/
public class WechatTest {
    private final static Long Id = 707829217L;
    public static boolean isPrime(int num){
        for(int i = 2;i<Math.sqrt(num);i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    @Test
    public void getWechatId(){
        for (int i = 2;i<Math.sqrt(Id);i++){
            if (isPrime(i)){
                if (Id % i == 0){
                    Long num1 = Id/i;
                    if (isPrime(num1.intValue())){
                        System.out.println("微信ID为:NY" + num1 + i);
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        List<Person> personList = new ArrayList<>(10);
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Person person = new Person();
                    person.setAge(finalI);
                    person.setName("name" + finalI);
                    personList.add(person);
                }
            }
            ).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(personList);
    }

    public void print(List<Person> personList) {
        System.out.println(personList.size());
        personList.forEach(item -> {
            if (item == null) {
                System.out.println("值" + item);
            }
        });
    }
}
