package com.example.live.service.impl;

import com.example.live.mapper.LandlordInformationMapper;
import com.example.live.pojo.LandlordInformation;
import com.example.live.service.LandlordInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordInformationServiceImpl implements LandlordInformationService {

    @Autowired
    private LandlordInformationMapper landlordInformationMapper;
    @Override
    public List<LandlordInformation> find(LandlordInformation object) {
        return landlordInformationMapper.find(object);
    }

    @Override
    public int insert(LandlordInformation object) {
        return landlordInformationMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return landlordInformationMapper.deleteById(id);
    }

    @Override
    public int update(LandlordInformation object) {
        return landlordInformationMapper.update(object);
    }
}
