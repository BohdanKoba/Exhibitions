package com.koba.exhibitions.bean;

import java.io.Serializable;

public class OrderExhibition implements Serializable {
    private static final long serialVersionUID = -5491954993702753675L;

    private Integer id;
    private Integer exhibitionId;
    private Short count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(Integer exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderExhibition{" +
                "id=" + id +
                ", exhibitionId=" + exhibitionId +
                ", count=" + count +
                '}';
    }

}
