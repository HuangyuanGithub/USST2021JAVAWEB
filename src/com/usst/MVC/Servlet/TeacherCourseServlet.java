package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.Dao.MessageOperation;
import com.usst.Dao.TeachOperation;
import com.usst.JavaBean.Course;
import com.usst.JavaBean.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TeacherCourseServlet", value = "/TeacherCourseServlet")
public class TeacherCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        List<Course> list = new ArrayList<>();
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        TeachOperation teachOperation = new TeachOperation();
        try {
            list = teachOperation.getAllCourse(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        request.setAttribute("ID",id);
        RequestDispatcher rd = request.getRequestDispatcher("teacherCourse.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}