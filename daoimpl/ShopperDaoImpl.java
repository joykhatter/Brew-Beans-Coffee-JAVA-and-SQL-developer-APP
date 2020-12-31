package com.daoimpl;

import com.connection.DBConnection;
import com.dao.ShopperDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShopperDaoImpl implements ShopperDao{
    private Connection con = null;
    private ResultSet rst = null;
    private PreparedStatement pst = null;
    
    // Report 1
    // Get information of shopper and his total purchase by calling tot_purch_sf function
    @Override
    public ResultSet getShopper(Integer shopperId, Boolean isEmpty) {
        con = DBConnection.getConnection();
        
            try {
                if(!isEmpty) {
                    pst = con.prepareStatement("select idshopper, firstname, lastname, address, city, state, tot_purch_sf(idshopper) from bb_shopper where idshopper = ?");
                    pst.setInt(1, shopperId);
                }
                else {
                    pst = con.prepareStatement("select idshopper, firstname, lastname, address, city, state, tot_purch_sf(idshopper) from bb_shopper");
                }
                rst = pst.executeQuery();
                        } catch (SQLException ex) {
                Logger.getLogger(ShopperDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return rst;
    }
    
}
