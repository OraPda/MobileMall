package com.edu.mall.dto;

import java.util.List;


public class CollectDto {
    private List<Integer> ids;
    private Integer type;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
