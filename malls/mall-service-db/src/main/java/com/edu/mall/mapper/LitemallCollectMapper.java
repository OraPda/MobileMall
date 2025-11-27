package com.edu.mall.mapper;

import com.edu.mall.dto.CollectDto;
import com.edu.mall.pojo.LitemallCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCollect record);

    int insertSelective(LitemallCollect record);

    LitemallCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallCollect record);

    int updateByPrimaryKey(LitemallCollect record);

    /*查询所有收藏商品*/
    List<LitemallCollect> selectAll(@Param("userId") Integer userId);

    /*批量删除收藏商品*/
    int deleteIds(@Param("dto")  CollectDto dto,@Param("userId")Integer userId);

    /*批量选中 或者未选中*/
    int updateType(@Param("dto") CollectDto dto, @Param("userId")Integer userId);
}