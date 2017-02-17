package com.coderbike.design_pattern.proxy;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/21 14:07
 */
public class Client {

    public static void main(String[] args) {
        Singer singer = new JayProxy(new Jay());
        singer.sing();
    }
}
