package com.edu.mall.vo;

import com.edu.mall.pojo.LitemallCategory;

import java.util.List;


public class MobileCategoryVo {
    private List<LitemallCategory> categoryList;
    private LitemallCategory currentCategory;
    private List<LitemallCategory> currentSubCategory;

    public List<LitemallCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<LitemallCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public LitemallCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(LitemallCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<LitemallCategory> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<LitemallCategory> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }
}
