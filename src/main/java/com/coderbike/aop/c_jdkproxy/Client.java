package com.coderbike.aop.c_jdkproxy;

/**
 * <p>
 *     jdk动态代理
 *     缺点：只能代理实现接口的类
 * <p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/:44
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("hello");
    }
}
