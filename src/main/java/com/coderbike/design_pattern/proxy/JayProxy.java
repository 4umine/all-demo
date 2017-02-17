package com.coderbike.design_pattern.proxy;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/21 14:03
 */
public class JayProxy implements Singer {

    private Singer singer;

    public JayProxy(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("找杰伦唱歌，先给钱");
        singer.sing();
    }
}
