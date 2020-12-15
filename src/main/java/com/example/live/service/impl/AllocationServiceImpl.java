package com.example.live.service.impl;

import com.example.live.mapper.AllocationMapper;
import com.example.live.pojo.Allocation;
import com.example.live.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    private AllocationMapper allocationMapper;

    @Override
    public List<Allocation> find(Allocation object) {
        return allocationMapper.find(object);
    }

    @Override
    public int insert(Allocation object) {
        return allocationMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return allocationMapper.deleteById(id);
    }

    @Override
    public int update(Allocation object) {
        return allocationMapper.update(object);
    }
}
