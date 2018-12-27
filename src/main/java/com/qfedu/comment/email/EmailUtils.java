package com.qfedu.comment.email;


import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;


/**
 * @author gfc
 * 基于JDK实现邮件发送
 * 主要是实现激活码的发送
 */
public class EmailUtils {

    /**
     * 发送邮件
     *
     * @param user     发件人邮箱
     * @param password 授权码（注意不是邮箱登录密码）
     * @param host
     * @param from     发件人
     * @param to       接收者邮箱
     * @param subject  邮件主题
     * @param content  邮件内容
     * @return boolean  true 发送成功 false 发送失败
     * @throws Exception
     */
    public static boolean sendMail(String user, String password, String host,
                                   String from, String to, String subject, String content) {
        if (to != null) {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            EmailAuthenticator auth = new EmailAuthenticator();
            EmailAuthenticator.USERNAME = user;
            EmailAuthenticator.PASSWORD = password;
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                if (!to.trim().equals("")) {
                    message.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(to.trim()));
                }
                message.setSubject(subject);
                // 正文
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setContent(content, "text/html;charset=utf-8");
                // 整个邮件：正文+附件
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                message.setContent(mp);
                message.setSentDate(new Date());
                message.saveChanges();
                Transport.send(message);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean sendModel(String email, int num) {
        String user = "m17303781561@163.com";
        String password = "z45683968";
        String host = "smtp.163.com";
        String from = "m17303781561@163.com";
        // 收件人
        String to = email;
        String subject = "验证码";
        boolean result = false;
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        int code = num;
        sb.append("<!DOCTYPE>" + "<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                + "<div style='width:950px;font-family:arial;'>欢迎使用美途美宿APP，您的注册码为：<br/><h2 style='color:green'>" + code + "</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>sport官网</div>"
                + "</div>");
        try {
            result = sendMail(user, password, host, from, to,
                    subject, sb.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
