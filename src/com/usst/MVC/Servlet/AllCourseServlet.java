package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllCourseServlet", value = "/AllCourseServlet")
public class AllCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List courseList = new ArrayList();
        CourseOperation CourseOperation=new CourseOperation();
        try {
            courseList = CourseOperation.getAllcourse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("courseList",courseList);
        RequestDispatcher rd = request.getRequestDispatcher("CourseView.jsp");
        rd.forward(request,response);
    }
}
