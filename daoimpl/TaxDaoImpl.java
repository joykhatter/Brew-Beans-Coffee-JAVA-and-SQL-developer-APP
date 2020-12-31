package com.daoimpl;
import com.connection.DBConnection;
import com.dao.TaxDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TaxDaoImpl implements TaxDao{
    private Connection con = null;
    private CallableStatement cs = null;
    private ResultSet rst = null;
    @Override
    public Double calculateTax(String shopperState, Double basketSubtotal) {
        Double tax = 1.0;
        try {
            con = DBConnection.getConnection();
            cs = con.prepareCall("{call tax_cost_sp(?,?,?)}");
            cs.setString(1, shopperState);
            cs.setDouble(2, basketSubtotal);
            cs.registerOutParameter(3, java.sql.Types.DOUBLE);
            int i = cs.executeUpdate();
            tax = cs.getDouble(3);
        } catch (SQLException ex) {
            Logger.getLogger(TaxDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tax;
    }
    
}
