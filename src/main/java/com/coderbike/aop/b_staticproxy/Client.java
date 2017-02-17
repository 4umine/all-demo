package com.coderbike.aop.b_staticproxy;

/**
 * <p>
 *     静态代理
 *     缺点：一个代理对象只能为一个接口服务，会产生过多的代理类
 * <p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 11:44
 */
public class Client {

    public static void main(String[] args) {
        GreetingProxy proxy = new GreetingProxy(new GreetingImpl());
        proxy.sayHello("fdd");
    }
}
