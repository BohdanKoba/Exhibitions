package com.koba.exhibitions.bean;

import java.io.Serializable;

public class ExhibitionData implements Serializable {
    private static final long serialVersionUID = -6387753930867712943L;

    private String title;
    private String description;
    private String price;
    private String startDate;
    private String endDate;
    private String openingTime;
    private String closingTime;

    public ExhibitionData(String title, String description, String price, String startDate, String endDate, String openingTime, String closingTime) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

}
