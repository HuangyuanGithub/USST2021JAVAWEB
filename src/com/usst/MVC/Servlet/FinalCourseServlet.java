package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.Dao.MessageOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FinalCourseServlet", value = "/FinalCourseServlet")
public class FinalCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        List courseList = new ArrayList();
        CourseOperation CourseOperation=new CourseOperation();
        try {
            courseList = CourseOperation.getfinalcourse(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("courseList",courseList);

        List messageList = new ArrayList();
        MessageOperation messageOperation = new MessageOperation();
        try {
            messageList = messageOperation.getFinalMessage(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("messageList",messageList);

        RequestDispatcher rd = request.getRequestDispatcher("finalCourse.jsp");
        rd.forward(request,response);



    }
}