package com.usst.Dao;

import com.usst.JavaBean.College;
import com.usst.JavaBean.Course;
import com.usst.JavaBean.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeachOperation {

    public List getAllCourse(int id) throws Exception {
        String sql = "select * from course where course.id in(select courseId from teach where teacherId=?)";
        DBHelper dbHelper = new DBHelper();
        List courses  = new ArrayList<Course>();
        ResultSet rs=dbHelper.query(sql,id);
        while(rs.next()){
            int idx = rs.getInt("id");
            String name = rs.getString("name");
            String collegeName = rs.getString("collegeName");
            String detail = rs.getString("detail");
            courses.add(new Course(idx,collegeName,name,detail));
        }
        return courses;
    }

    public void deleteTeach(int ID,int id) throws Exception {
        String sql = "delete from teach where teacherId=? and courseId = ?";
        DBHelper dbHelper = new DBHelper();
        dbHelper.update(sql,ID,id);

    }

    public List getAllTeacher(int id) throws Exception {
        String sql = "select * from teacher where teacher.id in(select teacherId from teach where courseId=?)";
        DBHelper dbHelper = new DBHelper();
        List teachers  = new ArrayList<Teacher>();
        ResultSet rs=dbHelper.query(sql,id);
        while(rs.next()){
            int idx = rs.getInt("id");
            String username = rs.getString("username");
            String position = rs.getString("position");
            String detail = rs.getString("detail");
            teachers.add(new Teacher(idx,username,position,detail));
        }
        return teachers;
    }

    public List getOtherTeacher(int id) throws Exception {
        String sql = "select * from teacher where teacher.id not in(select teacherId from teach where courseId=?)";
        DBHelper dbHelper = new DBHelper();
        List teachers  = new ArrayList<Teacher>();
        ResultSet rs=dbHelper.query(sql,id);
        while(rs.next()){
            int idx = rs.getInt("id");
            String username = rs.getString("username");
            String position = rs.getString("position");
            String detail = rs.getString("detail");
            teachers.add(new Teacher(idx,username,position,detail));
        }
        return teachers;
    }

    public List getOtherCourse(int id) throws Exception {
        String sql = "select * from course where course.id not in(select courseId from teach where teacherId=?)";
        DBHelper dbHelper = new DBHelper();
        List courses  = new ArrayList<Course>();
        ResultSet rs=dbHelper.query(sql,id);
        while(rs.next()){
            int idx = rs.getInt("id");
            String name = rs.getString("name");
            String collegeName = rs.getString("collegeName");
            String detail = rs.getString("detail");
            courses.add(new Course(idx,collegeName,name,detail));
        }
        return courses;
    }

    public void addTeach(int teacherId,int courseId) throws Exception {
        String sql = "insert into teach(teacherId,courseId) values(?,?)";
        DBHelper dbHelper = new DBHelper();
        dbHelper.update(sql,teacherId,courseId);

    }


}
