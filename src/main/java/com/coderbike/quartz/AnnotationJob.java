package com.coderbike.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/1/4 17:52
 */
@Component
public class AnnotationJob {

    @Scheduled(cron = "0/2 * * * * *")
    public void sayHello() {
        //System.out.println("hello " + new Date());
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }
}
