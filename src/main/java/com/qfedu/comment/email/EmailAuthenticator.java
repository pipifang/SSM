package com.qfedu.comment.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author zgc
 * 2018年12月07日 下午 8:53
 */
public class EmailAuthenticator extends Authenticator {
    public static String USERNAME = "m17303781561@163.com";
    public static String PASSWORD = "z45683968";

    public EmailAuthenticator() {
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, PASSWORD);
    }
}
