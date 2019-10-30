package com.example.spring.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MyInvocationHandler
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/11
 **/
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 被代理的对象
     */
    private Object target;
    public MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    /**
     * 通过代理对象对方法增强
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("after");
        return result;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
