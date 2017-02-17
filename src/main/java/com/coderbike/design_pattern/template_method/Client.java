package com.coderbike.design_pattern.template_method;

/**
 * <p>客户端<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/26 13:53
 */
public class Client {

    public static void main(String[] args) {
        AbstractClass ac = new ConcreteClass();
        ac.templateMethod();
    }
}
