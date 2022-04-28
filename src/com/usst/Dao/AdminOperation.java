package com.usst.Dao;

import java.sql.ResultSet;

public class AdminOperation {

    public int checkAdmin(String password) throws Exception {
        String sql = "select * from admin where password = ?" ;
        DBHelper dbHelper = new DBHelper();
        ResultSet rs = dbHelper.query(sql,password);
        int count=0;
        while(rs.next()) count++;
        return count;
    }

    public int alterAdmin(String password) throws Exception {
        String sql = "update admin set password=?";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,password);
        return count;
    }


}
