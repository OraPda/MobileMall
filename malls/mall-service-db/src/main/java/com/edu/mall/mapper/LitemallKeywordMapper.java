package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallKeyword;

public interface LitemallKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallKeyword record);

    int insertSelective(LitemallKeyword record);

    LitemallKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallKeyword record);

    int updateByPrimaryKey(LitemallKeyword record);
}