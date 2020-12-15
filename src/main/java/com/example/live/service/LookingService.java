package com.example.live.service;

import com.example.live.pojo.Looking;

import java.util.List;

public interface LookingService extends BaseService<Looking> {
    List<Looking> findHistoryLooking(Looking looking);
}
