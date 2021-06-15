package com.koba.exhibitions.bean;

import java.io.Serializable;

public class OrderData implements Serializable {
    private static final long serialVersionUID = 8665097883202316147L;

    private Integer accountId;
    private Integer exhibitionId;
    private Short quantity;
    private Integer bill;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(Integer exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

}
