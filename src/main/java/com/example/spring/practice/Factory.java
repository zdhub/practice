package com.example.spring.practice;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @ClassName Factory
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/11
 **/
public class Factory {
    public static ServiceImpl getInstance(CglibProxy proxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceImpl.class);
        enhancer.setCallback(proxy);
        ServiceImpl service = (ServiceImpl) enhancer.create();
        return service;
    }
}
