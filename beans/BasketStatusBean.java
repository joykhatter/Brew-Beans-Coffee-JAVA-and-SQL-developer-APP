package com.beans;

import java.io.Serializable;
import java.util.Date;

public class BasketStatusBean implements Serializable{
    private Integer statusID;
    private Integer basketID;
    private Integer stageID;
    private Date date;
    private String notes;
    private String shipper;
    private String shippingNum;
    
    public BasketStatusBean(){}
    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public Integer getBasketID() {
        return basketID;
    }

    public void setBasketID(Integer basketID) {
        this.basketID = basketID;
    }

    public Integer getStageID() {
        return stageID;
    }

    public void setStageID(Integer stageID) {
        this.stageID = stageID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getShippingNum() {
        return shippingNum;
    }

    public void setShippingNum(String shippingNum) {
        this.shippingNum = shippingNum;
    }
    
}
