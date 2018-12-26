package com.qfedu.comment.email;

import java.io.Serializable;

/**
 *@Author gfc
 *@Date Created in 2018/9/6 11:19
 */
public class EmailMsg implements Serializable {
    private String Title;
    private String Content;
    private String Email;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}