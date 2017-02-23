package com.coderbike.activemq.spirng_jms;

import com.coderbike.activemq.jms_crud.User;
import com.coderbike.activemq.jms_crud.UserDao;
import com.coderbike.activemq.message_converter.Email;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;
import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 11:10
 */
public class ConsumerMessageListener implements MessageListener {

    @Autowired
    private UserDao userDao;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Serializable serializable = objectMessage.getObject();

                // 测试事务
                if (serializable instanceof User) {
                    User user = (User) serializable;
                    System.out.println(user);
                    userDao.save(user);

                    throw new RuntimeException("报错了");
                } else if (serializable instanceof Email) {
                    Email email = (Email) serializable;
                    System.out.println("邮件内容：" + email.toString());
                }
            } else {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("消费者：" + textMessage.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
