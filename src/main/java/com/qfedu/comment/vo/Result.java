package com.qfedu.comment.vo;

import java.io.Serializable;

/**
 * @author gfc
 * 2018年11月28日 下午 5:29
 */
public class Result implements Serializable {
    private int code;

    private String msg;

    private Object data;

    private Object other;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }
}
