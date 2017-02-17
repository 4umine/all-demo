package com.coderbike.aop.e_springaop_programmatic;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 16:07
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after");
    }
}
