package com.qfedu.comment.utils;

import com.qfedu.comment.vo.PageResult;
import com.qfedu.comment.vo.Result;
import com.qfedu.comment.vo.ResultUtil;

/**
 * @author gfc
 * 2018年11月29日 下午 1:18
 */
public class ConvertUtil {

    public static Result convert(int i, String msg) {

        return i > 0 ? ResultUtil.setOK(msg, null) : ResultUtil.setERROR(msg);
    }

    public static Result convert(int i, String msg, Object data) {

        return i > 0 ? ResultUtil.setOK(msg, data) : ResultUtil.setERROR(msg);
    }

    public static Result convert(int i, String msg, Object data, String other) {

        return i > 0 ? ResultUtil.setOK(msg, other, data) : ResultUtil.setERROR(msg);
    }

    public static Result convert(String msg, Object data) {

        return data != null ? ResultUtil.setOK(msg, data) : ResultUtil.setERROR(msg);
    }

    public static PageResult convert(PageResult result) {
        return result != null ? result : null;
    }
}
