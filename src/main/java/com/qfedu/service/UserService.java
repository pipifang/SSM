package com.qfedu.service;

import com.qfedu.comment.vo.Result;
import com.qfedu.domain.User;

public interface UserService {

        /**
         * 上传头像
         * @param user
         * @return
         */
        Result updateHeadImage(User user);

        /**
         * 修改用户信息
         * @param user
         * @return
         */
        Result updateUserInfo(User user);

}
