package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallNotice;

public interface LitemallNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallNotice record);

    int insertSelective(LitemallNotice record);

    LitemallNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallNotice record);

    int updateByPrimaryKey(LitemallNotice record);
}