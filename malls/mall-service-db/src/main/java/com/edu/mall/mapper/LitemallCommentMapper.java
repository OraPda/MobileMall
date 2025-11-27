package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallComment;

public interface LitemallCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallComment record);

    int insertSelective(LitemallComment record);

    LitemallComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallComment record);

    int updateByPrimaryKey(LitemallComment record);
}