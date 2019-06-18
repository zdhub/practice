package com.example.spring.practice;

/**
 * @ClassName ServiceImpl
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/11
 **/
public class ServiceImpl implements Service {
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
