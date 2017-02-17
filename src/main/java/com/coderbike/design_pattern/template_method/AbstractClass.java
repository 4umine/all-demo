package com.coderbike.design_pattern.template_method;

/**
 * <p>抽象模板<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/26 10:40
 */
public abstract class AbstractClass {

    /**
     * <p>模板方法<p/>
     * author: imant
     * date: 2016/12/26 11:35
     */
    public void templateMethod() {
        doOption1();
        doOption2();
        doOption3();
        concreteMethod();
    }

    /**
     * 基本方法声明（由子类实现）
     */
    protected abstract void doOption1();

    protected abstract void doOption2();

    protected abstract void doOption3();

    /**
     * 基本方法声明（已经实现）
     */
    private void concreteMethod() {
        System.out.println("this is concrete method");
    }

    /**
     * 默认钩子方法
     */
    protected void doHookMethod() {
    }

}
