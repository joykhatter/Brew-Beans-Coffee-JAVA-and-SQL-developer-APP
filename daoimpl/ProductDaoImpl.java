package com.daoimpl;

import com.beans.ProductBean;
import com.connection.DBConnection;
import com.dao.ProductDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoImpl implements ProductDao{
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rst = null;
    private CallableStatement cs = null;
    
    // Get All products to show in table
    @Override
    public ResultSet getAllProducts() {
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("select idproduct, productname, description, productimage, price, active from bb_product");
            rst = pst.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rst;
    }
    
    // Get Product By Product Name
    @Override
    public ResultSet getProductByProductName(String productName) {
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("select idproduct, productname, description, productimage, price, active from bb_product where productname = ?");
            pst.setString(1, productName);
            rst = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rst;
    }
    
    // Get Product By Product Id in by search bar
    @Override
    public ProductBean getProductByProductID(Integer id) {
        ProductBean productBean = new ProductBean();
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("select idproduct, productname, description, productimage, price, active from bb_product where idproduct = ?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while(rst.next()) {
                productBean.setIDProduct(id);
                productBean.setProductName(rst.getString("productname"));
                productBean.setDescription(rst.getString("description"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productBean;
    }
    
    // Update Product Description by calling update_bb_product store procedure
    @Override
    public Boolean updateProductDescription(Integer productID, String description) {
        try {
            con = DBConnection.getConnection();
            cs = con.prepareCall("{call update_bb_product(?,?)}");
            cs.setInt(1, productID);
            cs.setString(2, description);
            return cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Add product to the database by calling prod_add_sp store procedure
    @Override
    public Boolean addProduct(ProductBean productBean) {
        try {
            con = DBConnection.getConnection();
            cs = con.prepareCall("{call prod_add_sp(?,?,?,?,?)}");
            cs.setString(1, productBean.getProductName());
            cs.setString(2, productBean.getDescription());
            cs.setString(3, productBean.getProductImage());
            cs.setDouble(4, productBean.getPrice());
            cs.setInt(5, productBean.getActive());
            return cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // Check if product is on sale by calling sql function
    @Override
    public String checkProduct(Integer productId, java.util.Date date) {
        String message = null;
        con = DBConnection.getConnection();
        try {
            cs = con.prepareCall("{? = call ck_sale_sf(?,?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setInt(2, productId);
            cs.setDate(3, new Date(date.getTime()));
            cs.executeUpdate();
            message = cs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
}
