package com.example.live.service.impl;

import com.example.live.mapper.UserPersonalInfoMapper;
import com.example.live.pojo.UserPersonalInfo;
import com.example.live.service.UserPersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPersonalInfoServiceImpl implements UserPersonalInfoService {

    @Autowired
    private UserPersonalInfoMapper userPersonalInfoMapper;

    @Override
    public List<UserPersonalInfo> find(UserPersonalInfo object) {
        return userPersonalInfoMapper.find(object);
    }

    @Override
    public int insert(UserPersonalInfo object) {
        return userPersonalInfoMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return userPersonalInfoMapper.deleteById(id);
    }

    @Override
    public int update(UserPersonalInfo object) {
        return userPersonalInfoMapper.update(object);
    }
}
