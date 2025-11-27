package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallTopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallTopic record);

    int insertSelective(LitemallTopic record);

    LitemallTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallTopic record);

    int updateByPrimaryKeyWithBLOBs(LitemallTopic record);

    int updateByPrimaryKey(LitemallTopic record);

    List<LitemallTopic> selectTopicList(@Param("limit") Integer limit);
}