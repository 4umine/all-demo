package com.coderbike.aop.b_staticproxy;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 14:45
 */
public class GreetingProxy implements Greeting {

    private GreetingImpl greeting;

    @Override
    public void sayHello(String name) {
        before();
        greeting.sayHello(name);
        after();
    }

    public GreetingProxy(GreetingImpl greeting) {
        this.greeting = greeting;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
