package com.example.live.service.impl;

import com.example.live.mapper.UserOpinionMapper;
import com.example.live.pojo.UserOpinion;
import com.example.live.service.UserOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOpinionServiceImpl implements UserOpinionService {

    @Autowired
    private UserOpinionMapper userOpinionMapper;
    @Override
    public List<UserOpinion> find(UserOpinion object) {
        return userOpinionMapper.find(object);
    }

    @Override
    public int insert(UserOpinion object) {
        return userOpinionMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return userOpinionMapper.deleteById(id);
    }

    @Override
    public int update(UserOpinion object) {
        return userOpinionMapper.update(object);
    }
}
