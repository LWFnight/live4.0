package com.example.live.mapper;

import com.example.live.pojo.Looking;

import java.util.List;

public interface LookingMapper extends BaseMapper<Looking> {
    List<Looking> findHistoryLooking(Looking looking);
}
