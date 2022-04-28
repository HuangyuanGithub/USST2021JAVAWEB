package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.JavaBean.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChooseCollegeServlet", value = "/ChooseCollegeServlet")
public class ChooseCollegeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        CourseOperation courseOperation = new CourseOperation();
        List<Course> list = new ArrayList<>();
        try {
            list = courseOperation.getCollegecourse(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        RequestDispatcher rd = request.getRequestDispatcher("chooseCourse.jsp");
        rd.forward(request,response);
    }
}