package com.example.live.controller;

import com.example.live.pojo.Allocation;
import com.example.live.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @RequestMapping(value = "findAllocation",method = RequestMethod.GET)
    public List<Allocation> findAllocation(Allocation allocation){
        return allocationService.find(allocation);
    }

    @RequestMapping(value = "updateAllocation",method = RequestMethod.POST)
    public boolean updateAllocation(Allocation allocation){
        allocationService.update(allocation);
        return true;
    }
}
