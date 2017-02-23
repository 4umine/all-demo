package com.coderbike.activemq.jms_crud;

import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/22 14:55
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4657636478248160469L;

    private Long id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
