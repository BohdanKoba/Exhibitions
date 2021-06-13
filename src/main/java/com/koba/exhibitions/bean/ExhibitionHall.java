package com.koba.exhibitions.bean;

import java.io.Serializable;

public class ExhibitionHall implements Serializable {
    private static final long serialVersionUID = -3368051222561750369L;

    private Integer exhibitionId;
    private Integer hallId;

    public Integer getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(Integer exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

}
