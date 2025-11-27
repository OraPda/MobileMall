package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallAdmin;

public interface LitemallAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAdmin record);

    int insertSelective(LitemallAdmin record);

    LitemallAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallAdmin record);

    int updateByPrimaryKey(LitemallAdmin record);
}