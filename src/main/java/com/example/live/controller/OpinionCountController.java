package com.example.live.controller;

import com.example.live.pojo.OpinionCount;
import com.example.live.service.OpinionCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OpinionCountController {

    @Autowired
    private OpinionCountService opinionCountService;

    @RequestMapping(value = "insertOpinionCount",method = RequestMethod.POST)
    public String insertOpinionCount(OpinionCount opinionCount){
        opinionCountService.insert(opinionCount);
        return "login";
    }

    @RequestMapping(value = "updateOpinionCount",method = RequestMethod.POST)
    public String updateOpinionCount(OpinionCount opinionCount){
        opinionCountService.update(opinionCount);
        return "login";
    }
}
