package com.coderbike.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/15 16:53
 */
public class Reciever {

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
        Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);

        // 4.创建Destination，并设置名字
        Destination destination = session.createQueue("queue");

        // 5.通过session创建生产者和消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 7.接受消息
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            if (message == null) {
                break;
            }
            // CLIENT_ACKNOWLEDGE模式需要人工签收确认
            message.acknowledge();
            System.out.println(message.getText());
        }

        // 8.关闭连接
        if (connection != null) {
            connection.close();
            System.out.println("connection关闭成功");
        }
    }
}
