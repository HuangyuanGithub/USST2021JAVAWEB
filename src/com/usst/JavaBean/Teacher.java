package com.usst.JavaBean;

public class Teacher {
    private int id;
    private String username;
    private String password;
    private String position;
    private String detail;

    public Teacher() {}

    public Teacher(int id, String username, String password, String position, String detail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.position = position;
        this.detail = detail;
    }

    public Teacher(int id, String username, String position, String detail) {
        this.id = id;
        this.username = username;
        this.position = position;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
