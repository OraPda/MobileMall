package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallRegionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallRegion record);

    int insertSelective(LitemallRegion record);

    LitemallRegion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallRegion record);

    int updateByPrimaryKey(LitemallRegion record);

    List<LitemallRegion> selectAll();

    List<LitemallRegion> selectByType(int type);

    List<LitemallRegion> selectById(Integer id, Integer type);

    /*根据县名称获得code的值*/
    LitemallRegion selectByName(@Param("name") String name);
}