package com.qfedu.comment.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author gfc
 * 2018年12月07日 下午 8:53
 */
public class EmailAuthenticator extends Authenticator {
    public static String USERNAME = "sue21205@163.com";
    public static String PASSWORD = "298560gfc";

    public EmailAuthenticator() {
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, PASSWORD);
    }
}
