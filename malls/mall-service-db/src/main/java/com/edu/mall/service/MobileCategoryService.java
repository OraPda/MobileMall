package com.edu.mall.service;

import com.edu.mall.vo.MobileCategoryVo;

import java.util.List;


public interface MobileCategoryService {
    /*查询分类页面数据*/
    MobileCategoryVo getCategoryIndex();
    /*查询指定父类的子分类*/
    MobileCategoryVo getCategoryAndSub(Integer id);
}
