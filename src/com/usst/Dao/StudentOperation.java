package com.usst.Dao;

import com.usst.JavaBean.Student;
import com.usst.JavaBean.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentOperation {

    public int checkStudent(String username, String password) throws Exception {
        String sql = "select id from student where username = ? and password =?" ;
        DBHelper dbHelper = new DBHelper();
        ResultSet rs = dbHelper.query(sql,username,password);
        int id=0;
        while(rs.next()) id= rs.getInt("id");
        return id;
    }

    public int checkStudentRegister(String username) throws Exception {
        String sql = "select id from student where username = ? " ;
        DBHelper dbHelper = new DBHelper();
        ResultSet rs = dbHelper.query(sql,username);
        int id=0;
        while(rs.next()) id= rs.getInt("id");
        if(id==0){
            sql = "select id from teacher where username = ? " ;
            rs = dbHelper.query(sql,username);
            while(rs.next()) id= rs.getInt("id");
        }
        return id;
    }

    public int addStudent(String username,String password) throws Exception {
        String sql = "insert into student(username,password) values (?,?)" ;
        DBHelper dbHelper = new DBHelper();
        int count=dbHelper.update(sql,username,password);
        return count;
    }

    public int alterStudentPassword(String username,String password) throws Exception {
        String sql = "update student set password =? where username=?" ;
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,password,username);
        return count;
    }

    public List<Student> getAllStudent() throws Exception {
        String sql = "select id,username from student";
        DBHelper dbHelper= new DBHelper();
        List students  = new ArrayList<Student>();
        ResultSet rs=dbHelper.query(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");

            students.add(new Student(id,username));
        }
        return students;
    }


}
