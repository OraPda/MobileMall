package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallPermission;

public interface LitemallPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallPermission record);

    int insertSelective(LitemallPermission record);

    LitemallPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallPermission record);

    int updateByPrimaryKey(LitemallPermission record);
}