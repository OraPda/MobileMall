package com.edu.mall.service.impl;

import com.edu.mall.mapper.LitemallCategoryMapper;
import com.edu.mall.pojo.LitemallCategory;
import com.edu.mall.service.MobileCategoryService;
import com.edu.mall.vo.MobileCategoryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MobileCategoryServiceImpl implements MobileCategoryService {
    @Resource
    private LitemallCategoryMapper litemallCategoryMapper;
    @Override
    public MobileCategoryVo getCategoryIndex() {
        MobileCategoryVo vo=new MobileCategoryVo();
        vo.setCategoryList(litemallCategoryMapper.selectLevel1ListBlob());
//        vo.setCurrentCategory(vo.getCategoryList().isEmpty()?vo.getCategoryList().get(0):null);
        if(!vo.getCategoryList().isEmpty()){
            vo.setCurrentCategory(vo.getCategoryList().get(0));
            vo.setCurrentSubCategory(litemallCategoryMapper.selectLevel1ListByPid(vo.getCurrentCategory().getId()));
        }
        return vo;
    }

    @Override
    public MobileCategoryVo getCategoryAndSub(Integer id) {
        MobileCategoryVo vo=new MobileCategoryVo();
        LitemallCategory litemallCategory = litemallCategoryMapper.selectByPrimaryKey(id);
        vo.setCurrentCategory(litemallCategory);
        if(litemallCategory!=null){
            vo.setCurrentSubCategory(litemallCategoryMapper.selectLevel1ListByPid(litemallCategory.getId()));
        }
        return vo;
    }
}
