package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallFootprint;

public interface LitemallFootprintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallFootprint record);

    int insertSelective(LitemallFootprint record);

    LitemallFootprint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallFootprint record);

    int updateByPrimaryKey(LitemallFootprint record);
}