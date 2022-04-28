package com.usst.MVC.Servlet;

import com.usst.Dao.CollegeOperation;
import com.usst.Dao.CourseOperation;
import com.usst.JavaBean.College;
import com.usst.JavaBean.Course;
import com.usst.MVC.Model.AlterPassword;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//密码和课程中的修改？
@WebServlet(name = "AlterServlet", value = "/AlterServlet")
public class AlterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String collegeName = request.getParameter("collegeName");
        String detail = request.getParameter("detail");

        CollegeOperation collegeOperation = new CollegeOperation();
        List<College> list= new ArrayList();
        try {
            list= collegeOperation.getAllCollege();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("collegeList",list);
        request.setAttribute("id",id);
        request.setAttribute("collegeName",collegeName);
        request.setAttribute("detail",detail);
        RequestDispatcher rd = request.getRequestDispatcher("alterCourse.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String status = request.getParameter("status");
        AlterPassword alterPassword = new AlterPassword();
        try {
            alterPassword.alterPassword(username,password,status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request,response);
    }
}


