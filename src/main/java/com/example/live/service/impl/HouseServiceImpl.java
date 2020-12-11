package com.example.live.service.impl;

import com.example.live.mapper.HouseMapper;
import com.example.live.pojo.House;
import com.example.live.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;
    @Override
    public List<House> find(House object) {
        return houseMapper.find(object);
    }

    @Override
    public int insert(House object) {
        return houseMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return houseMapper.deleteById(id);
    }

    @Override
    public int update(House object) {
        return houseMapper.update(object);
    }

    @Override
    public List<House> findHouseByUserId(Integer user_id) {
        return houseMapper.findHouseByUserId(user_id);
    }
}
