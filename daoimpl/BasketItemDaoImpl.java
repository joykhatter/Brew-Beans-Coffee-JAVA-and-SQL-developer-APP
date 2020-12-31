package com.daoimpl;

import com.beans.BasketItemBean;
import com.connection.DBConnection;
import com.dao.BasketItemDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BasketItemDaoImpl implements BasketItemDao{
    private Connection con = null;
    private CallableStatement cs = null;
    private PreparedStatement pst = null;
    private ResultSet rst = null;
    // Add Item to baske by calling basket_add_sp
    @Override
    public Boolean addBasketItem(BasketItemBean basketItemBean) {
        try {
            con = DBConnection.getConnection();
            cs = con.prepareCall("{call basket_add_sp(?,?,?,?,?,?)}");
            cs.setInt(1, basketItemBean.getBasketId());
            cs.setInt(2, basketItemBean.getProductId());
            cs.setInt(3, basketItemBean.getQuantity());
            cs.setDouble(4, basketItemBean.getPrice());
            cs.setInt(5, basketItemBean.getSizeCode());
            cs.setInt(6, basketItemBean.getFormCode());
            return cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BasketItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // Get all Basket Items to show in table
    @Override
    public ResultSet getAllBasketItems() {
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT bb_basketitem.idbasketitem, bb_basketitem.idbasket, bb_product.productname, bb_basketitem.price, bb_basketitem.quantity, bb_basketitem.option1, bb_basketitem.option2 from bb_basketitem inner join bb_product on bb_basketitem.idproduct = bb_product.idproduct");         
            rst = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BasketItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rst;
    }
    
    // Checking Items in stock by executing plsql statement
    @Override
    public String checkItemStock(Integer basketId) {
        String message = "";
        try {
            con = DBConnection.getConnection();
            String sql = "DECLARE\n" +
                         " CURSOR cur_basket IS\n" +
                         " SELECT bi.idBasket, bi.quantity, p.stock\n" +
                         " FROM bb_basketitem bi INNER JOIN bb_product p\n" +
                         " USING (idProduct)\n" +
                         " WHERE bi.idBasket = ?;\n" +
                         " TYPE type_basket IS RECORD (\n" +
                         " basket bb_basketitem.idBasket%TYPE,\n" +
                         " quantity bb_basketitem.quantity%TYPE,\n" +
                         " stock bb_product.stock%TYPE);\n" +
                         " rec_basket type_basket;\n" +
                         " lv_flag_txt CHAR(1) := 'Y';\n" +
                         " message VARCHAR2(100) := '';"+
                         "BEGIN\n" +
                         " FOR rec_basket IN cur_basket\n" +
                         " LOOP\n" +
                         " IF rec_basket.stock < rec_basket.quantity THEN lv_flag_txt := 'N'; END IF;\n" +
                         " END LOOP;\n" +
                         " IF lv_flag_txt = 'Y' THEN message := 'All items in stock!'; END IF;\n" +
                         " IF lv_flag_txt = 'N' THEN message := 'All items NOT in stock!'; END IF;\n" +
                         " ? := message;" +
                         "END;";
            cs = con.prepareCall(sql);
            cs.setInt(1, basketId);
            cs.registerOutParameter(2, Types.VARCHAR);
            if(cs.executeUpdate() > 0)
                message = cs.getString(2);
        } catch (SQLException ex) {
            Logger.getLogger(BasketItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
}
