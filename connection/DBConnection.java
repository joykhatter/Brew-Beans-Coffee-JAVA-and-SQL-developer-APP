package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {

    private static Connection con = null;

    private DBConnection() {
    }

    public static Connection getConnection() {
        if (con == null) {
            try {
                
                Class.forName("oracle.jdbc.driver.OracleDriver");
                // Add your username(brewbeans) add password(admin)
                con = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.scs.ryerson.ca:1521:orcl12c", "jkhatter", "spider10");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return con;
    }
}
