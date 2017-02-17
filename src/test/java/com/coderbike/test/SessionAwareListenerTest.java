package com.coderbike.test;

import com.coderbike.activemq.spirng_jms.ProduceService;
import com.coderbike.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.jms.Destination;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 15:26
 */
public class SessionAwareListenerTest extends BaseTest {

    @Autowired
    private ProduceService produceService;

    @Autowired
    @Qualifier("sessionAwareQueue")
    private Destination sessionAwareDes;

    @Test
    public void sendMsgBySessionAware() {
        produceService.sendMsg(sessionAwareDes, "SessionAware消息");
    }
}
