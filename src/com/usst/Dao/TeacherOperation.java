package com.usst.Dao;

import com.usst.JavaBean.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TeacherOperation {
    public List<Teacher> getAllTeacher() throws Exception {
        String sql = "select * from teacher";
        DBHelper dbHelper= new DBHelper();
        List teachers  = new ArrayList<Teacher>();
        ResultSet rs=dbHelper.query(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String position = rs.getString("position");
            String detail = rs.getString("detail");

            teachers.add(new Teacher(id,username,password,position,detail));
        }
        return teachers;
    }

    public void deleteTeacher(int id) throws Exception {
        String sql = "delete from teacher where id = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,id);
    }


    public int alterTeacher(int id,String username,String password,String position,String detail) throws Exception {
        String sql = "update teacher set username=?,password=?,position=?,detail=? where id=?";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,username,password,position,detail,id);
        return count;
    }

    public int addTeacher(String username,String password,String position,String detail) throws Exception {
        String sql = "insert into teacher(username,password,position,detail) values(?,?,?,?)";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,username,password,position,detail);
        return count;

    }

    public int checkTeacher(String username, String password) throws Exception {
        String sql = "select id from teacher where username = ? and password =?" ;
        DBHelper dbHelper = new DBHelper();
        ResultSet rs = dbHelper.query(sql,username,password);
        int count=0;
        while(rs.next()) count=rs.getInt("id");
        return count;
    }

    public int alterTeacherPassword(String username,String password) throws Exception {
        String sql = "update teacher set password =? where username=?" ;
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,password,username);
        return count;
    }

    public List<Teacher> getAllOtherTeacher(int studentId) throws Exception {
        String sql = "select * from teacher where id not in(select teacherId from exclude where studentId = ?)";
        DBHelper dbHelper= new DBHelper();
        List teachers  = new ArrayList<Teacher>();
        ResultSet rs=dbHelper.query(sql,studentId);
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String position = rs.getString("position");
            String detail = rs.getString("detail");

            teachers.add(new Teacher(id,username,password,position,detail));
        }
        return teachers;
    }
}
