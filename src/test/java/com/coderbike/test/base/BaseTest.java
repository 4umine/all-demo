package com.coderbike.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/11/16 15:33
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class BaseTest {
}
