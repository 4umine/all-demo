package com.coderbike.aop.e_springaop_programmatic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 16:02
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }
}
