package com.coderbike.aop.a_hardcoding;

/**
 * <p>硬编码<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 11:44
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        greeting.sayHello("hi");
    }
}
