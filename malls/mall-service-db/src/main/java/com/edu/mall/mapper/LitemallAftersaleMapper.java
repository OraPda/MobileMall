package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallAftersale;

public interface LitemallAftersaleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAftersale record);

    int insertSelective(LitemallAftersale record);

    LitemallAftersale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallAftersale record);

    int updateByPrimaryKey(LitemallAftersale record);
}