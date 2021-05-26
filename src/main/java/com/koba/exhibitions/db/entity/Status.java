package com.koba.exhibitions.db.entity;

import java.io.Serializable;

public class Status implements Serializable {
    private static final long serialVersionUID = 6142454190892499476L;

    private Integer id;
    private String statusName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }

}
