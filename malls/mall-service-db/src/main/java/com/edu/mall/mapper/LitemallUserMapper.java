package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallUser record);

    int insertSelective(LitemallUser record);

    LitemallUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallUser record);/*这个的话就是 你的数据如果name=null*/

    int updateByPrimaryKey(LitemallUser record);/*这个的话  是它是需要所有数据都填充*/

    /*通过用户名查询用户信息*/
    LitemallUser selectUserByUsername(@Param("username") String username);


}