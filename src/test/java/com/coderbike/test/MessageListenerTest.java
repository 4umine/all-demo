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
 * date: 2017/2/17 13:37
 */
public class MessageListenerTest extends BaseTest {

    @Autowired
    private ProduceService produceService;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Test
    public void sendMsg() {
        for (int i=0; i<2; i++) {
            produceService.sendMsg(destination, "消息" + i);
        }
    }

}
