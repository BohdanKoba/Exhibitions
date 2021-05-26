package com.koba.exhibitions.db.entity;

import java.io.Serializable;

public class Hall implements Serializable {
    private static final long serialVersionUID = -4453144475600554739L;

    private Integer id;
    private String hallName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", hallName='" + hallName + '\'' +
                '}';
    }

}
