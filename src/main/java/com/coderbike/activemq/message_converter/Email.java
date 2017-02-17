package com.coderbike.activemq.message_converter;

import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/17 16:30
 */
public class Email implements Serializable {

    private static final long serialVersionUID = 1977088867334264830L;

    /** 用户名 */
    private String username;

    /** 邮箱地址 */
    private String emailAddress;

    /** 邮件内容 */
    private String content;

    public Email(String username, String emailAddress, String content) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "username='" + username + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
