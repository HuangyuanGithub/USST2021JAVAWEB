package com.usst.JavaBean;

public class Course {
    private int id;
    private String collegeName;
    private String name;
    private String detail;

    public Course() {}

    public Course(int id,String collegeName, String name, String detail) {
        this.id = id;
        this.collegeName = collegeName;
        this.name = name;
        this.detail = detail;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
