package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallLog;

public interface LitemallLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallLog record);

    int insertSelective(LitemallLog record);

    LitemallLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallLog record);

    int updateByPrimaryKey(LitemallLog record);
}