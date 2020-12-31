package com.dao;
public interface TaxDao {
    public Double calculateTax(String shopperState, Double basketSubtotal);
}
