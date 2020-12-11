package com.example.live.mapper;

import com.example.live.pojo.House;

import java.util.List;

public interface HouseMapper extends BaseMapper<House> {
    List<House> findHouseByUserId(Integer user_id);
}
