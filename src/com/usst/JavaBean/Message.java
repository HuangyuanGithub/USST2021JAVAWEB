package com.usst.JavaBean;

public class Message {
    private int id;
    private int courseId;
    private int studentId;
    private String title;
    private String text;
    private String date;
    private String answer;
    private int teacherId;
    private String courseName;
    private String teacherName;
    private String studentName;

    public Message() {}

    public Message(int id, String title, String text, String date,String answer,String courseName, String teacherName, String studentName) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.answer = answer;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.studentName = studentName;
    }

    public Message(int id, String title, String text, String date, String answer, String courseName, String studentName) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.answer = answer;
        this.courseName = courseName;
        this.studentName = studentName;
    }

    public Message(int id, String title, String answer, String courseName) {
        this.id = id;
        this.title = title;
        this.answer = answer;
        this.courseName = courseName;
    }

    public Message(int id, String title, String text, String answer, String courseName) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.answer = answer;
        this.courseName = courseName;
    }

    public Message(int id, String title, String text, String date, String courseName, String studentName) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.courseName = courseName;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
