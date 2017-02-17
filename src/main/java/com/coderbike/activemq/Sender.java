package com.coderbike.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/15 16:53
 */
public class Sender {

    public static void main(String[] args) throws Exception {
        // 1.建立ConnectionFactory工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616");

        // 2.创建连接，开启连接（连接默认是关闭的）
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 3.创建Session会话，设置是否开启事务和签收模式

        // 不开启事务，AUTO_ACKNOWLEDGE模式
        //Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        // 开启事务，AUTO_ACKNOWLEDGE模式
        //Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        // 开启事务，CLIENT_ACKNOWLEDGE模式，需要消费者ACKNOWLEDGE
        Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);

        // 4.创建Destination，并设置名字
        Destination destination = session.createQueue("queue");

        // 5.通过session创建生产者和消费者
        MessageProducer producer = session.createProducer(destination);

        // 6.设置消息是否要持久化，即DeliveryMode（递交模式）
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // 7.设置消息，并发送
        for (int i=1; i<=5; i++) {
            TextMessage message = session.createTextMessage("我是生产者" + i + "号");
            producer.send(message);
        }

        // 如果session开启事务，那么事务必须提交才能消息发送成功
        session.commit();

        // 8.关闭连接
        if (connection != null) {
            connection.close();
            System.out.println("connection关闭成功");
        }
    }
}
