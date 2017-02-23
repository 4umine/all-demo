package com.coderbike.test.jms_crud;

import com.coderbike.activemq.jms_crud.User;
import com.coderbike.activemq.jms_crud.UserDao;
import com.coderbike.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/22 15:19
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAdd() {
        System.out.println("userDao============" + userDao);
        userDao.save(new User("刀刀", 2));
    }
}
