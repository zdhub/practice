package com.example.spring.practice;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/11
 **/
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        methodProxy.invokeSuper(object, args);
        System.out.println("after");
        return null;
    }
}
