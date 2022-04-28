package com.usst.Dao;
import java.sql.*;

public class DBHelper {
    Connection connection;
    final String DRIVER="com.mysql.cj.jdbc.Driver";
    final String URL = "jdbc:mysql://127.0.0.1:3306/question";
    final String USERNAME = "root";
    final String PASSWORD = "1234";

    public DBHelper(){}

    /*
    jdbc操作
     */
    public void getConnection() throws Exception {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }

    /*
    增加 删除 修改 操作
    返回影响的行数
     */
    public int update(String sql,Object... params) throws Exception { //...可变参数数组
        getConnection();
        int count;
        PreparedStatement statement = connection.prepareStatement(sql);
        for(int i=0;i<params.length;i++){
            statement.setObject(i+1,params[i]);
        }
        count=statement.executeUpdate();
        statement.close();
        closeConnection();
        return count;
    }


    /*
    执行一个查询，返回查询结果集
     */
    public ResultSet query(String sql,Object... params) throws Exception {
        getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        for(int i=0;i<params.length;i++){
            statement.setObject(i+1,params[i]);
        }
        ResultSet rs =statement.executeQuery();
        return rs;

    }

    /*
    返回一个记录
     */



}
