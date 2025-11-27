package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallStorage;

public interface LitemallStorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallStorage record);

    int insertSelective(LitemallStorage record);

    LitemallStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallStorage record);

    int updateByPrimaryKey(LitemallStorage record);
}