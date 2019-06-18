package com.example.spring.practice;

import org.junit.Test;

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
}
