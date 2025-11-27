package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallNoticeAdmin;

public interface LitemallNoticeAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallNoticeAdmin record);

    int insertSelective(LitemallNoticeAdmin record);

    LitemallNoticeAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallNoticeAdmin record);

    int updateByPrimaryKey(LitemallNoticeAdmin record);
}