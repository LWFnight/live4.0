package com.example.live.mapper;

import java.util.List;

public interface BaseMapper<T> {
    List<T> find(T object);
    int insert(T object);
    int deleteById(Integer id);
    int update(T object);
}
