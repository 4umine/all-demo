package com.coderbike.activemq.spirng_jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 14:25
 */
@Service
public class ConsumerSessionMessageListener implements SessionAwareMessageListener<TextMessage> {

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        System.out.println("============");
        System.out.println("ConsumerSessionMessageListener接收消息：" + textMessage.getText());

        MessageProducer producer = session.createProducer(destination);
        Message message = session.createTextMessage("ConsumerSessionMessageListener消息");
        producer.send(message);
    }
}
