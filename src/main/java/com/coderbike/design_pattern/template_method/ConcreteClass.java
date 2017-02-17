package com.coderbike.design_pattern.template_method;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/26 13:46
 */
public class ConcreteClass extends AbstractClass {

    @Override
    protected void doOption1() {
        System.out.println("option1");
    }

    @Override
    protected void doOption2() {
        System.out.println("option2");
    }

    @Override
    protected void doOption3() {
        System.out.println("option3");
    }
}
