package com.coderbike.aop.e_springaop_programmatic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <p>
 *     环绕增强
 *     org.aopalliance.intercept.MethodInterceptor
 *     aop联盟的接口，spring只是借用
 * <p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/10 16:20
 */
public class GreetingAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
