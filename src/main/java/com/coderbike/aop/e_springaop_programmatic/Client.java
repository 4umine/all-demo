package com.coderbike.aop.e_springaop_programmatic;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * <p>spring aop<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 15:36
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();     //创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());         //射入目标类对象
        proxyFactory.addAdvice(new GreetingBeforeAdvice()); //添加前置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());  //添加后置增强

        Greeting greeting = (Greeting) proxyFactory.getProxy(); //获取代理类
        greeting.sayHello("hello");                             //调用代理方法
    }

    @Test
    public void testBeforeAndAfter() {
        ProxyFactory proxyFactory = new ProxyFactory();             //创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());                 //射入目标类对象
        //一个类同时实现 MethodBeforeAdvice 和 AfterReturningAdvice
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();     //获取代理类
        greeting.sayHello("test");                                  //调用代理方法
    }

    @Test
    public void testAround() {
        ProxyFactory proxyFactory = new ProxyFactory();             //创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());                 //射入目标类对象
        //实现 MethodInterceptor
        proxyFactory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();     //获取代理类
        greeting.sayHello("around");                                //调用代理方法
    }
}
