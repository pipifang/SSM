package com.qfedu.comment.filter;

import com.alibaba.fastjson.JSON;
import com.qfedu.comment.constant.Constant;
import com.qfedu.comment.utils.JedisUtil;
import com.qfedu.comment.vo.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter("/*")
public class TokenFilter implements Filter {
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        JedisUtil jedisUtil = new JedisUtil("www.sueyun.cn", 6379, "298560");
        String uri = req.getRequestURI();
        if (uri.contains("/api/v1/password")) {
            String email = req.getParameter("email");
            String code = req.getParameter("code");
            if (Objects.equals(jedisUtil.getStr(email), code)) {
                chain.doFilter(request, response);
            } else {
                resp.getWriter().print(JSON.toJSONString(ResultUtil.setOtherERROR("验证码不正确")));
                return;
            }
        }
        if (uri.contains("/api/v1/code") || uri.contains("/api/v1/codeLogin") || uri.contains("/api/v1/login")) {
            chain.doFilter(request, response);
        } else {
            String token = req.getHeader("token");

            if (token == null || token == "") {
                resp.getWriter().print(JSON.toJSONString(ResultUtil.setOtherERROR("没有登录")));
                return;
            } else {

                String hashToken = jedisUtil.getHash(Constant.TOKENKEY, token);

                if (hashToken != null) {
                    chain.doFilter(request, response);
                    return;
                }
                String strToken = jedisUtil.getHash(Constant.CODETOKENKEY, "token" + token);
                if (strToken != null) {
                    chain.doFilter(request, response);
                    return;
                }
            }

            resp.getOutputStream().print(JSON.toJSONString(ResultUtil.setOtherERROR("Please Login")));
        }
    }

    @Override
    public void destroy() {

    }
}
