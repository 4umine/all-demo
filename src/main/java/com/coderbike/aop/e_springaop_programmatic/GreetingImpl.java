package com.coderbike.aop.e_springaop_programmatic;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 11:41
 */
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println(name);
    }
}
