package com.coderbike.abstract_DI;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/11/16 15:14
 */
public abstract class AbstractTest implements TestInterface {

    @Autowired
    protected TestUser testUser;
}
