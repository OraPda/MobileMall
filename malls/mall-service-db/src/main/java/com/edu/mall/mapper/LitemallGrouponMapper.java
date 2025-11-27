package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallGroupon;

public interface LitemallGrouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGroupon record);

    int insertSelective(LitemallGroupon record);

    LitemallGroupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallGroupon record);

    int updateByPrimaryKey(LitemallGroupon record);
}