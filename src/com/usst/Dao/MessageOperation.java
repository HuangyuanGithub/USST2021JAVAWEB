package com.usst.Dao;

import com.usst.JavaBean.College;
import com.usst.JavaBean.Message;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageOperation {
    public List<Message> getAllMessage() throws Exception {
        String sql = "select M.id,C.name as courseName,S.username as studentName,M.title,M.text,M.date from message as M left join course as C on M.courseId = C.id left join student as S on M.studentId = S.id";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");

            messages.add(new Message(id,title,text,date,courseName,studentName));
        }
        return messages;
    }

    public void deleteMessage(int id) throws Exception {
        String sql = "delete from message where id = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,id);
    }

    public int alterMessage(int id,String title,String text) throws Exception {
        String sql = "update message set title=?,text=? where id=?";
        DBHelper dbHelper = new DBHelper();
        int count = dbHelper.update(sql,title,text,id);
        return count;
    }

    public int addMessage(int courseId,int studentId,String title,String text,String date) throws Exception {
        DBHelper dbHelper = new DBHelper();
        StudentOperation studentOperation = new StudentOperation();
        String sql = "insert into message(courseId,studentId,title,text,date) values(?,?,?,?,?)";
        int count = dbHelper.update(sql,courseId,studentId,title,text,date);
        return count;
    }

    public List<Message> getMyMessage(int studentId) throws Exception {
        String sql = "select M.id,C.name as courseName,S.username as studentName,M.title,M.text,M.date from message as M left join course as C on M.courseId = C.id left join student as S on M.studentId = S.id where M.studentId= ?";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql,studentId);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");
            messages.add(new Message(id,title,text,date,courseName,studentName));
        }
        return messages;
    }


    public List<Message> getTeacherMessage(int teacherId) throws Exception {
        String sql = "select M.id,C.name as courseName,S.username as studentName,M.title,M.text,M.date\n" +
                "from message as M left join course as C on M.courseId = C.id \n" +
                "left join student as S on M.studentId = S.id join teach as T on T.teacherId = ? and T.courseId = M.courseId\n" +
                "where M.studentId not in (select studentId from exclude where exclude.teacherId = T.teacherId) ";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql,teacherId);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");
            messages.add(new Message(id,title,text,date,courseName,studentName));
        }
        return messages;
    }

    public List<Message> getAllAnswer(int ID) throws Exception {
        String sql = "select M.id,C.name as courseName,S.username as studentName,M.title,M.text,M.date,M.answer from message as M \n" +
                "left join course as C on M.courseId = C.id left join student as S on M.studentId = S.id where M.teacherId = ?";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql,ID);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");
            String answer = rs.getString("answer");

            messages.add(new Message(id,title,text,date,answer,courseName,studentName));
        }
        return messages;
    }

    public void deleteAnswer(int id) throws Exception {
        String sql = "update message set answer = null,teacherId = null where id = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,id);
    }

    public List<Message> getAnswer(int ID) throws Exception {
        String sql = "select M.id,M.title,M.answer,M.text,C.name from message as M left join student as S on S.id = M.studentId left join course as C on M.courseId=C.id  where M.id = ?";
        DBHelper dbHelper =new DBHelper() ;
        ResultSet rs = dbHelper.query(sql,ID);
        List messages  = new ArrayList<Message>();
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("name");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String answer = rs.getString("answer");

            messages.add(new Message(id,title,text,answer,courseName));
        }
        return messages;
    }

    public void addAnswer(int id,String answer,int teacherId) throws Exception {
        String sql = "update message set answer = ?,teacherId = ? where id = ?";
        DBHelper dbHelper= new DBHelper();
        dbHelper.update(sql,answer,teacherId,id);
    }

    public int teacherAllNew(int id) throws Exception {
        String sql = "select M.id,C.name as courseName,S.username as studentName,M.title,M.text,M.date,M.answer\n" +
                "from message as M left join course as C on M.courseId = C.id \n" +
                "left join student as S on M.studentId = S.id join teach as T on T.courseId = M.courseId\n" +
                "where M.answer is null and M.studentId not in (select studentId from exclude where exclude.teacherId = T.teacherId)" +
                "and  T.teacherId = ? ";
        DBHelper dbHelper= new DBHelper();
        ResultSet rs = dbHelper.query(sql,id);
        int count=0;
        while(rs.next()){
            count++;
        }
        return count;
    }

    public List<Message> getAllNewMessage(int teacherId) throws Exception {
        String sql = "select M.id,C.name as courseName,S.username as studentName,M.title,M.text,M.date,M.answer\n" +
                "from message as M left join course as C on M.courseId = C.id \n" +
                "left join student as S on M.studentId = S.id join teach as T on T.courseId = M.courseId\n" +
                "where M.answer is null and M.studentId not in (select studentId from exclude where exclude.teacherId = T.teacherId) " +
                "and  T.teacherId = ? ";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql,teacherId);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");
            String answer = rs.getString("answer");
            messages.add(new Message(id,title,text,date,answer,courseName,studentName));
        }
        return messages;
    }


    public List<Message> getCourseMessage(int teacherId,int courseId) throws Exception {
        String sql = "select M.id,C.name as courseName,S.username as studentName,M.title,M.text,M.date,M.answer\n" +
                "from message as M left join course as C on M.courseId = C.id \n" +
                "left join student as S on M.studentId = S.id join teach as T on T.teacherId = ? and T.courseId = M.courseId\n" +
                "where M.courseId = ? and M.studentId not in (select studentId from exclude where exclude.teacherId = T.teacherId) ";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql,teacherId,courseId);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");
            String answer = rs.getString("answer");
            messages.add(new Message(id,title,text,date,answer,courseName,studentName));
        }
        return messages;
    }

    public int studentAllNew(int id) throws Exception {
        String sql = "select M.id,C.name as courseName,M.title,M.text,M.date,M.answer\n" +
                "from message as M left join course as C on M.courseId=C.id\n" +
                "where M.studentId = ? and M.answer is not null and M.flag is null";
        DBHelper dbHelper= new DBHelper();
        ResultSet rs = dbHelper.query(sql,id);
        int count=0;
        while(rs.next()){
            count++;
        }
        return  count;
    }

    public List<Message> studentAllNewMessage(int id) throws Exception {
        String sql = "select M.id,C.name as courseName,M.title,M.text,M.date,M.answer\n" +
                "from message as M left join course as C on M.courseId=C.id\n" +
                "where M.studentId = ? and M.answer is not null and M.flag is null";
        DBHelper dbHelper= new DBHelper();
        ResultSet rs = dbHelper.query(sql,id);
        int count=0;
        List messages  = new ArrayList<Message>();
        while(rs.next()){
            int ID = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String title = rs.getString("title");
            String answer = rs.getString("answer");
            String date = rs.getString("date");
            messages.add(new Message(ID,title,answer,date,courseName,"-1"));
        }
        return messages;

    }


    public List<Message> studentToNewMessage(int id) throws Exception {
        String sql = "select M.id,C.name as courseName,M.title,M.text,M.date,M.answer\n" +
                "from message as M left join course as C on M.courseId=C.id\n" +
                " where M.id = ?";
        DBHelper dbHelper= new DBHelper();
        ResultSet rs = dbHelper.query(sql,id);
        int count=0;
        List messages  = new ArrayList<Message>();
        while(rs.next()){
            int ID = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String answer = rs.getString("answer");
            messages.add(new Message(ID,title,text,answer,courseName));
        }
        return messages;

    }





    public List<Message> getFinalMessage(int courseId) throws Exception {
        String sql = "select * from message where courseId = ?";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql,courseId);
        while(rs.next()){
            int id = rs.getInt("id");

            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");
            String answer = rs.getString("answer");

            messages.add(new Message(id,title,text,date,answer,"",""));
        }
        return messages;
    }

    public void reset(int id){
        String sql = "update message set teacherId = null,flag = null,answer = null where id= ?";
        DBHelper dbHelper= new DBHelper();
        try {
            dbHelper.update(sql,id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void alterFlag(int id){
        String sql = "update message set flag = 1 where id= ?";
        DBHelper dbHelper= new DBHelper();
        try {
            dbHelper.update(sql,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void teacherreset(int id){
        String sql = "update message set teacherId = null,flag = null where id= ?";
        DBHelper dbHelper= new DBHelper();
        try {
            dbHelper.update(sql,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Message> getAllSearchMessage(String keyword1,String keyword2,String keyword3,String keyword4,String keyword5) throws Exception {
        String sql = "select M.id,C.name as courseName,C.collegeName as collegeName,T.username as teacherName,S.username as studentName,M.title,M.text,M.date from message as M\n" +
                "left join course as C on M.courseId = C.id left join student as S on M.studentId = S.id left join teacher as T on T.id = M.teacherId\n" +
                "where C.name like ? or title like ? or text like ? or C.collegeName like ? or T.username like ?";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql,keyword1,keyword2,keyword3,keyword4,keyword5);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String teacherName = rs.getString("teacherName");
            String answer = rs.getString("collegeName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");
            messages.add(new Message(id,title,text,date,answer,courseName,teacherName,studentName));
        }
        return messages;
    }

    public List<Message> getAllSearchMessages() throws Exception {
        String sql = "select M.id,C.name as courseName,C.collegeName as collegeName,T.username as teacherName,S.username as studentName,M.title,M.text,M.date from message as M\n" +
                "left join course as C on M.courseId = C.id left join student as S on M.studentId = S.id left join teacher as T on T.id = M.teacherId";
        DBHelper dbHelper= new DBHelper();
        List messages  = new ArrayList<Message>();
        ResultSet rs=dbHelper.query(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            String teacherName = rs.getString("teacherName");
            String answer = rs.getString("collegeName");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");


            messages.add(new Message(id,title,text,date,answer,courseName,teacherName,studentName));
        }
        return messages;
    }






}
