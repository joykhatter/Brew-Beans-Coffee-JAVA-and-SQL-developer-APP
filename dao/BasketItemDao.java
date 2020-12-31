package com.dao;

import com.beans.BasketItemBean;
import java.sql.ResultSet;

public interface BasketItemDao {
    public Boolean addBasketItem(BasketItemBean basketItemBean);
    public ResultSet getAllBasketItems();
    public String checkItemStock(Integer basketId); 
}
