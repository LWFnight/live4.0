package com.example.live.controller;

import com.example.live.pojo.Feature;
import com.example.live.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @RequestMapping(value = "findFeature",method = RequestMethod.GET)
    public List<Feature> findFeature(Feature feature){
        return featureService.find(feature);
    }

    @RequestMapping(value = "updateFeature",method = RequestMethod.POST)
    public boolean updateFeature(Feature feature){
        featureService.update(feature);
        return true;
    }
}
