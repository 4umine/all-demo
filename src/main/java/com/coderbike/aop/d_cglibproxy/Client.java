package com.coderbike.aop.d_cglibproxy;

/**
 * <p>cglib动态代理<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 15:36
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = CglibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("hello");
    }
}
