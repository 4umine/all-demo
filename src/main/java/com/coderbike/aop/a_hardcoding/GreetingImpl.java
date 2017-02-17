package com.coderbike.aop.a_hardcoding;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 11:41
 */
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        before();
        System.out.println("hello");
        after();
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
