package com.beans;

import java.io.Serializable;
import java.util.Date;

public class ProductBean implements Serializable{
    private Integer IDProduct;
    private String productName;
    private String description;
    private String productImage;
    private Double price;
    private Date saleStart;
    private Date saleEnd;
    private Double salePrice;
    private Integer active;
    private Integer featured;
    private Date featureStart;
    private Date featureEnd;
    private Character type;
    private Integer IDDepartment;
    private Integer stock;
    private Integer ordered;
    private Integer reorder;

    public Integer getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(Integer IDProduct) {
        this.IDProduct = IDProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getSaleStart() {
        return saleStart;
    }

    public void setSaleStart(Date saleStart) {
        this.saleStart = saleStart;
    }

    public Date getSaleEnd() {
        return saleEnd;
    }

    public void setSaleEnd(Date saleEnd) {
        this.saleEnd = saleEnd;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getFeatured() {
        return featured;
    }

    public void setFeatured(Integer featured) {
        this.featured = featured;
    }

    public Date getFeatureStart() {
        return featureStart;
    }

    public void setFeatureStart(Date featureStart) {
        this.featureStart = featureStart;
    }

    public Date getFeatureEnd() {
        return featureEnd;
    }

    public void setFeatureEnd(Date featureEnd) {
        this.featureEnd = featureEnd;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public Integer getIDDepartment() {
        return IDDepartment;
    }

    public void setIDDepartment(Integer IDDepartment) {
        this.IDDepartment = IDDepartment;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Integer getReorder() {
        return reorder;
    }

    public void setReorder(Integer reorder) {
        this.reorder = reorder;
    }
}
