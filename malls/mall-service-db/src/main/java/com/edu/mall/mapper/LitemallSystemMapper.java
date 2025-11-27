package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallSystem;

public interface LitemallSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSystem record);

    int insertSelective(LitemallSystem record);

    LitemallSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallSystem record);

    int updateByPrimaryKey(LitemallSystem record);
}