package com.coderbike.activemq.message_converter;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 16:32
 */
public class EmailMessageConverter implements MessageConverter {

    @Override
    public Message toMessage(Object obj, Session session) throws JMSException, MessageConversionException {
        return session.createObjectMessage((Serializable) obj);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        ObjectMessage objectMessage = (ObjectMessage) message;
        return objectMessage.getObject();
    }
}
