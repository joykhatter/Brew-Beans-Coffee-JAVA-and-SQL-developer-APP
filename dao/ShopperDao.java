package com.dao;

import java.sql.ResultSet;

public interface ShopperDao {
    public ResultSet getShopper(Integer shopperId, Boolean isTrue);
}
