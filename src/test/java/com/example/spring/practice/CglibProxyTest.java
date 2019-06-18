package com.example.spring.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class CglibProxyTest {
    @Test
    public void test(){
        CglibProxy proxy = new CglibProxy();
        Service service = Factory.getInstance(proxy);
        service.add();
    }
}