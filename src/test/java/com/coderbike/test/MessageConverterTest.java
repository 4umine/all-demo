package com.coderbike.test;

import com.coderbike.activemq.message_converter.Email;
import com.coderbike.activemq.spirng_jms.ProduceService;
import com.coderbike.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.Destination;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 16:41
 */
public class MessageConverterTest extends BaseTest {

    @Autowired
    private ProduceService produceService;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Test
    public void sendMsg() {
        Email email = new Email("刀刀", "imant@outlook.com", "消息转换器");
        produceService.sendAndConverteMsg(destination, email);
    }

    @Test
    public void appContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DefaultMessageListenerContainer container = (DefaultMessageListenerContainer) context.getBean("consumerMsgConverterListenerContainer");
        Destination destination = (Destination) context.getBean("msgConverterQueue");
        System.out.println(destination);

    }
}
