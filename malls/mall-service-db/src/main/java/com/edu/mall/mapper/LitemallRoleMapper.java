package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallRole;

public interface LitemallRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallRole record);

    int insertSelective(LitemallRole record);

    LitemallRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallRole record);

    int updateByPrimaryKey(LitemallRole record);
}