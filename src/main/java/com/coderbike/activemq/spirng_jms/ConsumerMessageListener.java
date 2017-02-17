package com.coderbike.activemq.spirng_jms;

import com.coderbike.activemq.message_converter.Email;

import javax.jms.*;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 11:10
 */
public class ConsumerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Email email = (Email) objectMessage.getObject();
                System.out.println("邮件内容：" + email.toString());
            } else {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("开始接受消息：");
                System.out.println("消息内容为：" + textMessage.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
