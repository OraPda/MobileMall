package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallIssue;

public interface LitemallIssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallIssue record);

    int insertSelective(LitemallIssue record);

    LitemallIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallIssue record);

    int updateByPrimaryKey(LitemallIssue record);
}