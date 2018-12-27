package com.qfedu.service.impl;

import com.qfedu.comment.constant.Constant;
import com.qfedu.comment.utils.ConvertUtil;
import com.qfedu.comment.utils.EncrypUtil;
import com.qfedu.comment.vo.Result;
import com.qfedu.domain.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public Result updateHeadImage(User user) {
        return ConvertUtil.convert(mapper.updateHeadImage(user), "修改头像");
    }

    @Override
    public Result updateUserInfo(User user) {
        if (user != null && user.getPassword() != null) {
            EncrypUtil.encAesStr(Constant.REGISTERKEY, user.getPassword());
        }
        return ConvertUtil.convert(mapper.updateByPrimaryKeySelective(user), "修改信息");
    }
}
