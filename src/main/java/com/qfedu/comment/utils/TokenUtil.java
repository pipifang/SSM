package com.qfedu.comment.utils;

import com.alibaba.fastjson.JSON;
import com.qfedu.comment.constant.Constant;
import com.qfedu.comment.token.Token;

import java.util.Random;

/**
 * @author gfc
 * 2018年12月03日 下午 3:37
 */
public class TokenUtil {
    /**
     * 创建用户令牌
     * @param content
     * @param id
     * @return
     */
    public static String createToken(String content, int id) {
        Token token = new Token(content, System.currentTimeMillis(), id, new Random().nextLong());
        String json = JSON.toJSONString(token);
        return EncrypUtil.encAesStr(Constant.TOKENKEY, json);
    }

    /**
     * 解析令牌
     * @param token
     * @return
     */
    public static Token parseToken(String token) {
        String json = EncrypUtil.decAesStr(Constant.TOKENKEY, token);
        return JSON.parseObject(json, Token.class);
    }

    /**
     * 更新令牌
     * @param token
     * @return
     */
    public static String updateToken(Token token) {
        token.setTime(System.currentTimeMillis());
        return EncrypUtil.encAesStr(Constant.TOKENKEY, JSON.toJSONString(token));
    }
}
