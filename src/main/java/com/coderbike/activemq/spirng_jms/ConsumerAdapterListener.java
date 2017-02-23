package com.coderbike.activemq.spirng_jms;

import com.coderbike.activemq.message_converter.Email;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 15:20
 */
public class ConsumerAdapterListener {

    /**
     * 如果不指定MessageListenerAdapter中defaultListenerMethod属性，
     * 则默认调用handleMessage方法
     */
    public String handleMessage(String message) {
        System.out.println("AdapterConsumerListener通过handleMessage处理消息：" + message);
        return "来自handleMessage的返回消息";
    }

    public void receiveMessage(String message) {
        System.out.println("AdapterConsumerListener通过recieveMessage处理消息：" + message);
    }

    public void receiveConverteMsg(Email email) {
        System.out.println("AdapterConsumerListener通过recieveConverteMsg处理消息" + email.toString());
    }
}
