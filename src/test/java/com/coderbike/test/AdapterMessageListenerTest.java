package com.coderbike.test;

import com.coderbike.activemq.jms_crud.User;
import com.coderbike.activemq.message_converter.Email;
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
 * date: 2017/2/17 15:28
 */
public class AdapterMessageListenerTest extends BaseTest {

    @Autowired
    private ProduceService produceService;

    @Autowired
    @Qualifier("adapterDestination")
    private Destination adapterDestination;

    @Test
    public void sendMsg() {
        produceService.sendMsg(adapterDestination, "adapter消息");
    }

    @Test
    public void sendConverteMsg() {
        Email email = new Email("刀刀", "imant@outlook.com", "adapter转换消息");
        produceService.sendAndConverteMsg(adapterDestination, email);
    }

    @Test
    public void txTest() {
        produceService.sendAndConverteMsg(adapterDestination, new User("刀刀", 3));
    }
}
