package com.usst.Dao;

import com.usst.JavaBean.College;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CollegeOperation {
    public List<College> getAllCollege() throws Exception {
        String sql = "select * from college order by(id)";
        DBHelper dbHelper= new DBHelper();
        List colleges  = new ArrayList<College>();
        ResultSet rs=dbHelper.query(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            colleges.add(new College(id,name));
        }
        return colleges;
    }

    public void deleCollege(int idx) throws Exception {
        String sql = "delete from college where id = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,idx);
    }


    public int alterCollege(int id,String name) throws Exception {
        String sql = "update college set name=? where id=?";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,name,id);
        return count;
    }

    public int addCollege(String name) throws Exception {
        String sql = "insert into college(name) values(?)";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,name);
        return count;

    }

    public void alterall(String name,String old) throws Exception {
        String sql = "update course set collegeName = ? where collegeName = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,name,old);
    }



}
