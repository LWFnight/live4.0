package com.example.live.service.impl;

import com.example.live.mapper.UserMapper;
import com.example.live.pojo.User;
import com.example.live.service.UserService;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUsers(User user) {
        return userMapper.findUsers(user);
    }

    @Override
    public User findUserPersonalInfo(User user) {
        return userMapper.findUserPersonalInfo(user);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUserByUserId(Integer user_id) {
        return userMapper.deleteUserByUserId(user_id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
