package com.usst.Dao;

import com.usst.JavaBean.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CourseOperation {
    public List<Course> getAllcourse() throws Exception {
        String sql = "select * from course";
        DBHelper dbHelper= new DBHelper();
        List courses  = new ArrayList<Course>();
        ResultSet rs=dbHelper.query(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String collegeName = rs.getString("collegeName");
            String name = rs.getString("name");
            String detail = rs.getString("detail");

            courses.add(new Course(id,collegeName,name,detail));
        }
        return courses;
    }

    public void deleteCourse(int id) throws Exception {
        String sql = "delete from course where id = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,id);
    }


    public int alterCourse(int id,String name,String collegeName,String detail) throws Exception {
        String sql = "update course set name=?,collegeName=?,detail=? where id=?";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,name,collegeName,detail,id);
        return count;
    }

    public int addCourse(String name,String collegeName,String detail) throws Exception {
        String sql = "insert into course(name,collegeName,detail) values(?,?,?)";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,name,collegeName,detail);
        return count;

    }

    public List<Course> getCourseName() throws Exception {
        String sql = "select id,name from course";
        DBHelper dbHelper= new DBHelper();
        List courses  = new ArrayList<Course>();
        ResultSet rs=dbHelper.query(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            courses.add(new Course(id,name));
        }
        return courses;
    }

    public List<Course> getCollegecourse(String collegeName) throws Exception {
        String sql = "select * from course where collegeName = ?";
        DBHelper dbHelper= new DBHelper();
        List courses  = new ArrayList<Course>();
        ResultSet rs=dbHelper.query(sql,collegeName);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            courses.add(new Course(id,name));
        }
        return courses;
    }

    public List<Course> getfinalcourse(int courseId) throws Exception {
        String sql = "select * from course where id = ?";
        DBHelper dbHelper= new DBHelper();
        List courses  = new ArrayList<Course>();
        ResultSet rs=dbHelper.query(sql,courseId);
        while(rs.next()){
            int id = rs.getInt("id");
            String collegeName = rs.getString("collegeName");
            String name = rs.getString("name");
            String detail = rs.getString("detail");

            courses.add(new Course(id,collegeName,name,detail));
        }
        return courses;
    }



}
