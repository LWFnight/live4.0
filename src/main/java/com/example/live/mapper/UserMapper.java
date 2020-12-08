package com.example.live.mapper;

import com.example.live.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface UserMapper {
    List<User> findUsers(User user);
    User findUserPersonalInfo(User user);
    int insertUser(User user);
    int deleteUserByUserId(Integer user_id);
    int updateUser(User user);
}
