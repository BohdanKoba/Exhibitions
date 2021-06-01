package com.koba.exhibitions.db.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class ExhibitionData implements Serializable {
    private static final long serialVersionUID = -6387753930867712943L;

    private String title;
    private String description;
    private String price;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Integer categoryId;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer category) {
        this.categoryId = categoryId;
    }

}
