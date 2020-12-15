package com.example.live.service.impl;

import com.example.live.mapper.LookingMapper;
import com.example.live.pojo.Looking;
import com.example.live.service.LookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookingServiceImpl implements LookingService {

    @Autowired
    private LookingMapper lookingMapper;
    @Override
    public List<Looking> find(Looking object) {
        return lookingMapper.find(object);
    }

    @Override
    public int insert(Looking object) {
        return lookingMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return lookingMapper.deleteById(id);
    }

    @Override
    public int update(Looking object) {
        return lookingMapper.update(object);
    }

    @Override
    public List<Looking> findHistoryLooking(Looking looking) {
        return lookingMapper.findHistoryLooking(looking);
    }
}
