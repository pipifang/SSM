package com.qfedu.controller;

import com.alibaba.fastjson.JSON;
import com.qfedu.comment.token.Token;
import com.qfedu.comment.utils.OSSUtil;
import com.qfedu.comment.utils.TokenUtil;
import com.qfedu.comment.vo.Result;
import com.qfedu.domain.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zcg
 * @data 2018/12/27/15:20
 * @ClassNameUserController
 * @Description用户操作
 */
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    OSSUtil ossUtil;
    /**
     * 上传头像，需要用户id
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/head")
    public Result uploadHeadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename() + System.currentTimeMillis();
        String image = ossUtil.fileUp(filename, file.getBytes());
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        User user = JSON.parseObject(parseToken.getContent(), User.class);
        user.setImage(image);
        return service.updateHeadImage(user);
    }

    /**
     * 根据用户id修改信息
     *
     * @param user
     * @return
     */
    @PostMapping("/info")
    public Result updateUserInfo(User user, HttpServletRequest request) {
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        User user1 = JSON.parseObject(parseToken.getContent(), User.class);
        user.setId(user1.getId());
        return service.updateUserInfo(user);
    }


}
