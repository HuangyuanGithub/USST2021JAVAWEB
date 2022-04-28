package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.Dao.TeacherOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllTeacherServlet", value = "/AllTeacherServlet")
public class AllTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List teacherList = new ArrayList();
        HttpSession session = request.getSession();
        TeacherOperation teacherOperation=new TeacherOperation();
        try {
            if(session.getAttribute("status").equals("admin"))teacherList = teacherOperation.getAllTeacher();
            else teacherList = teacherOperation.getAllOtherTeacher((Integer) session.getAttribute("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("teacherList",teacherList);
        if(session.getAttribute("status").equals("admin")) {
            RequestDispatcher rd = request.getRequestDispatcher("teacherView.jsp");
            rd.forward(request, response);
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("chooseTeacher.jsp");
            rd.forward(request,response);
        }
    }
}
