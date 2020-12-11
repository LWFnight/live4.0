package com.example.live.service;

import com.example.live.pojo.House;

import java.util.List;

public interface HouseService extends BaseService<House> {
    List<House> findHouseByUserId(Integer user_id);
}
