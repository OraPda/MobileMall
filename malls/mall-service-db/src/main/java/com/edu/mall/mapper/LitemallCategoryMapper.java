package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCategory record);

    int insertSelective(LitemallCategory record);

    LitemallCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallCategory record);

    int updateByPrimaryKey(LitemallCategory record);
    /*查询所有一级分类 */
    List<LitemallCategory> selectLevel1List();
    /*查询所有一级分类的全部字段*/
    List<LitemallCategory> selectLevel1ListBlob();
    /*查询指定夫分类的子分类*/
    List<LitemallCategory> selectLevel1ListByPid(@Param("pid")Integer pid);
}