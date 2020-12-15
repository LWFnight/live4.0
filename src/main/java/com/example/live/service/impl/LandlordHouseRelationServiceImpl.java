package com.example.live.service.impl;

import com.example.live.mapper.LandlordHouseRelationMapper;
import com.example.live.mapper.LandlordInformationMapper;
import com.example.live.pojo.LandlordHouseRelation;
import com.example.live.pojo.LandlordInformation;
import com.example.live.service.LandlordHouseRelationService;
import com.example.live.service.LandlordInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordHouseRelationServiceImpl implements LandlordHouseRelationService {

    @Autowired
    private LandlordHouseRelationMapper landlordHouseRelationMapper;

    @Override
    public List<LandlordHouseRelation> find(LandlordHouseRelation object) {
        return landlordHouseRelationMapper.find(object);
    }

    @Override
    public int insert(LandlordHouseRelation object) {
        return landlordHouseRelationMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return landlordHouseRelationMapper.deleteById(id);
    }

    @Override
    public int update(LandlordHouseRelation object) {
        return landlordHouseRelationMapper.update(object);
    }
}
