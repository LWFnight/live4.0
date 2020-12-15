package com.example.live.service.impl;

import com.example.live.mapper.FeatureMapper;
import com.example.live.pojo.Feature;
import com.example.live.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureMapper featureMapper;
    @Override
    public List<Feature> find(Feature object) {
        return featureMapper.find(object);
    }

    @Override
    public int insert(Feature object) {
        return featureMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return featureMapper.deleteById(id);
    }

    @Override
    public int update(Feature object) {
        return featureMapper.update(object);
    }
}
