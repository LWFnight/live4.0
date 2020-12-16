package com.example.live.service.impl;

import com.example.live.mapper.AgentMapper;
import com.example.live.pojo.Agent;
import com.example.live.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentMapper agentMapper;
    @Override
    public List<Agent> find(Agent object) {
        return agentMapper.find(object);
    }

    @Override
    public int insert(Agent object) {
        return agentMapper.insert(object);
    }

    @Override
    public int deleteById(Integer id) {
        return agentMapper.deleteById(id);
    }

    @Override
    public int update(Agent object) {
        return agentMapper.update(object);
    }
}
