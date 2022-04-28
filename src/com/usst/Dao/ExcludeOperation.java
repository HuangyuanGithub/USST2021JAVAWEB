package com.usst.Dao;

import com.usst.JavaBean.College;
import com.usst.JavaBean.Exclude;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExcludeOperation {
    public List<College> getAllExclude(int ID) throws Exception {
        String sql = "select E.id,S.username from exclude as E join student as S on S.id = E.studentId and E.teacherId = ?";
        DBHelper dbHelper= new DBHelper();
        List excludes  = new ArrayList<Exclude>();
        ResultSet rs=dbHelper.query(sql,ID);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("username");
            excludes.add(new Exclude(id,name));
        }
        return excludes;
    }

    public void deleExclude(int idx) throws Exception {
        String sql = "delete from exclude where id = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,idx);
    }

    public void addExclude(int studentId,int teacherId) throws Exception {
        String sql = "insert into exclude (studentId,teacherId) values (?,?)";
        DBHelper dbHelper = new DBHelper();
        dbHelper.update(sql,studentId,teacherId);

    }
}
