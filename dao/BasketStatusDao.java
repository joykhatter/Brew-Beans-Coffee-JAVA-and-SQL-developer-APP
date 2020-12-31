package com.dao;

import com.beans.BasketStatusBean;
import java.sql.ResultSet;

public interface BasketStatusDao {
    public Boolean updateBasketStatus(BasketStatusBean basketStatusBean);
    public ResultSet getAllBasketStatus();
}
