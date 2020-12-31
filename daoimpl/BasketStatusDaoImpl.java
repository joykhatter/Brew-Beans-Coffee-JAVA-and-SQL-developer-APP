package com.daoimpl;

import com.beans.BasketStatusBean;
import com.connection.DBConnection;
import com.dao.BasketStatusDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasketStatusDaoImpl implements BasketStatusDao{
    private Connection con = null;
    private CallableStatement cs = null;
    private PreparedStatement pst = null;
    private ResultSet rst = null;
    
    // Update Shipment by calling status_ship_sp store procedure
    @Override
    public Boolean updateBasketStatus(BasketStatusBean basketStatusBean) {
        try {
            con = DBConnection.getConnection();
            cs = con.prepareCall("{call status_ship_sp(?,?,?,?)}");
            cs.setInt(1, basketStatusBean.getBasketID());
            cs.setDate(2, new Date(basketStatusBean.getDate().getTime()));
            cs.setString(3, basketStatusBean.getShipper());
            cs.setString(4, basketStatusBean.getShippingNum());
            return cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BasketStatusDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // Get all status of all baskets
    @Override
    public ResultSet getAllBasketStatus() {
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("select idstatus, idbasket,idstage, dtstage, notes, shipper, shippingnum from bb_basketstatus");
            rst = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BasketStatusDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rst;
    }
    
    
}
