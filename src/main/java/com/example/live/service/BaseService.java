package com.example.live.service;

import java.util.List;

public interface BaseService<T> {
    List<T> find(T object);
    int insert(T object);
    int deleteById(Integer id);
    int update(T object);
}
