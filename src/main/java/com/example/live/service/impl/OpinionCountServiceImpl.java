package com.example.live.service.impl;

import com.example.live.mapper.OpinionCountMapper;
import com.example.live.pojo.OpinionCount;
import com.example.live.service.OpinionCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionCountServiceImpl implements OpinionCountService {

    @Autowired
    private OpinionCountMapper opinionCountMapper;
    @Override
    public List<OpinionCount> find(OpinionCount object) {
        return null;
    }

    @Override
    public int insert(OpinionCount object) {
        return opinionCountMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int update(OpinionCount object) {
        return opinionCountMapper.update(object);
    }
}
