package com.example.live.service;

import com.example.live.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUsers(User user);
    User findUserPersonalInfo(User user);
    int insertUser(User user);
    int deleteUserByUserId(Integer user_id);
    int updateUser(User user);
}
