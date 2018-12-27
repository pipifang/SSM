package com.qfedu.mapper;

import com.qfedu.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(User user);

    int updatePassword(User user);

    int updateHeadImage(User user);

    User selectByEmail(String email);
}