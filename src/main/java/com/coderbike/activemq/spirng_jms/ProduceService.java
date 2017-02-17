package com.coderbike.activemq.spirng_jms;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 10:41
 */
public interface ProduceService {

    void sendMsg(Destination destination, final String message);

    void sendAndConverteMsg(Destination destination, final Serializable obj);
}
