package com.coderbike.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/16 14:21
 */
public class SelectorReciever {

    //private static final String SELECTOR = "name = 'daodao'";
    private static final String SELECTOR = "name = 'daodao2'";

    private static ConnectionFactory factory;
    private static Connection connection;
    private static Session session;

    public SelectorReciever() {
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
        SelectorReciever reciever = new SelectorReciever();
        reciever.recieveMsg();
    }

    public void recieveMsg() throws Exception {
        Destination destination = session.createQueue("imantMsg");
        MessageConsumer consumer = session.createConsumer(destination, SELECTOR);
        consumer.setMessageListener(new ConsumerListener());
    }

    /** 消费者listener */
    class ConsumerListener implements MessageListener {

        @Override
        public void onMessage(Message message) {
            if (message instanceof MapMessage) {
                try {
                    System.out.println("name=" + ((MapMessage) message).getString("name"));
                    System.out.println("nameProperty=" + message.getStringProperty("name"));
                    System.out.println(((MapMessage) message).getInt("age"));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
