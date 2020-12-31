package com.dao;

import com.beans.ProductBean;
import java.sql.ResultSet;
import java.util.Date;

public interface ProductDao {
    public ResultSet getAllProducts();
    public ResultSet getProductByProductName(String productName);
    public ProductBean getProductByProductID(Integer id);
    public Boolean updateProductDescription(Integer productID, String description);
    public Boolean addProduct(ProductBean productBean);
    public String checkProduct(Integer productId, Date date);
}
