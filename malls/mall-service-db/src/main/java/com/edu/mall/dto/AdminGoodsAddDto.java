package com.edu.mall.dto;

import com.edu.mall.pojo.LitemallGoods;
import com.edu.mall.pojo.LitemallGoodsAttribute;
import com.edu.mall.pojo.LitemallGoodsProduct;
import com.edu.mall.pojo.LitemallGoodsSpecification;

import java.util.Map;


public class AdminGoodsAddDto {
    private LitemallGoods goods;
    private LitemallGoodsSpecification specifications;
    private LitemallGoodsProduct products;
    private LitemallGoodsAttribute attributes;

    public LitemallGoods getGoods() {
        return goods;
    }

    public void setGoods(LitemallGoods goods) {
        this.goods = goods;
    }

    public LitemallGoodsSpecification getSpecifications() {
        return specifications;
    }

    public void setSpecifications(LitemallGoodsSpecification specifications) {
        this.specifications = specifications;
    }

    public LitemallGoodsProduct getProducts() {
        return products;
    }

    public void setProducts(LitemallGoodsProduct products) {
        this.products = products;
    }

    public LitemallGoodsAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(LitemallGoodsAttribute attributes) {
        this.attributes = attributes;
    }
}
