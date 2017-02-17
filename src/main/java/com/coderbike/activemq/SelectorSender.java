package com.coderbike.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.*;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/16 14:21
 */
public class SelectorSender {

    private static ConnectionFactory factory;
    private static Connection connection;
    private static Session session;

    public SelectorSender() {
        try {
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                    "tcp://localhost:61616");
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SelectorSender sender = new SelectorSender();
        sender.sendMsg();
    }

    public void sendMsg() throws Exception {
        Destination destination = session.createQueue("imantMsg");
        MapMessage message = new ActiveMQMapMessage();
        message.setString("name", "daodao");
        message.setIntProperty("age", 7);
        message.setStringProperty("name", "daodao");

        MapMessage message2 = new ActiveMQMapMessage();
        message2.setString("name", "daodao2");
        message2.setIntProperty("age", 8);
        message2.setStringProperty("name", "daodao2");

        MessageProducer producer = session.createProducer(destination);

        //最后一个参数timeToLive，消息的过期时间
        producer.send(message, DeliveryMode.NON_PERSISTENT, 2, 1000*60*24L);
        producer.send(message2, DeliveryMode.NON_PERSISTENT, 8, 1000*60*24L);

    }
}
