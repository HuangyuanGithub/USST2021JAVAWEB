package com.usst.MVC.Servlet;


import com.usst.Dao.TeachOperation;
import com.usst.JavaBean.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChooseTeacherServlet", value = "/ChooseTeacherServlet")
public class ChooseTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        List<Course> list = new ArrayList<>();
        TeachOperation teachOperation = new TeachOperation();
        try {
            list = teachOperation.getAllCourse(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        RequestDispatcher rd = request.getRequestDispatcher("chooseCourse.jsp");
        rd.forward(request,response);
    }
}
