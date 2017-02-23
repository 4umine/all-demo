package com.coderbike.activemq.spirng_jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 10:42
 */
@Service
public class ProducerServiceImpl implements ProduceService {

    @Resource
    private JmsTemplate jmsTemplate;

    /** adapter listener response destination */
    @Autowired
    @Qualifier("queueDestination")
    private Destination responseDes;

    /**
     * <p>生产者发送消息<p/>
     * author: imant
     * date: 2017/2/20 16:53
     */
    @Override
    public void sendMsg(Destination destination, String message) {
        System.out.println("生产者：" + message);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //指定消息回复destination
                //Message textMessage = session.createTextMessage(message);
                //textMessage.setJMSReplyTo(responseDes);
                //return textMessage;

                return session.createTextMessage(message);
            }
        });
    }

    @Override
    public void sendAndConverteMsg(Destination destination, Serializable obj) {
        jmsTemplate.convertAndSend(destination, obj);
    }
}
