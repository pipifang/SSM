package com.qfedu.service;

import com.qfedu.comment.vo.Result;
import com.qfedu.domain.User;

/**
 * @author zcg
 */
public interface LoginService {

    /**
     * /**
     * 用户输入邮箱，发送验证码
     * @param email 用户邮箱
     * @param ip 用户ip
     * @return
     */
    Result sendCode(String email,String ip);

    /**
     * 用户输入验证码验证登录
     *
     * @param code 验证码
     * @return
     */
    Result codeLogin(String email, String code,String ip);

    /**
     * 用户名密码登录，可使用邮箱或者用户名登录
     * @param user
     * @return
     */
    Result userLogin(User user, String ip);

    /**
     *用户退出
     * @param token
     * @return
     */
    Result loginOut(String token);

    /**
     * 找回密码
     * @param user
     * @return
     */
    Result findPassword(User user);

}
