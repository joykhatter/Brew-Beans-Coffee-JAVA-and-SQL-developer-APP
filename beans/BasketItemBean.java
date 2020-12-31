package com.beans;

import java.io.Serializable;
public class BasketItemBean implements Serializable{
    private Integer itemId;
    private Integer basketId;
    private Integer productId;
    private Integer quantity;
    private Double price;
    private Integer sizeCode;
    private Integer formCode;
    
    public BasketItemBean() {
        
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {
        this.basketId = basketId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(Integer sizeCode) {
        this.sizeCode = sizeCode;
    }

    public Integer getFormCode() {
        return formCode;
    }

    public void setFormCode(Integer formCode) {
        this.formCode = formCode;
    }
}
