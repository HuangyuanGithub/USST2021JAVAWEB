package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.Dao.TeachOperation;
import com.usst.JavaBean.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowCourseServlet", value = "/ShowCourseServlet")
public class ShowCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id;
        HttpSession session = request.getSession();
        if(session.getAttribute("teacherName")==null||(!session.getAttribute("teacherName").equals(request.getParameter("name"))&&request.getParameter("name")!=null)) {
            String teacherName = request.getParameter("name");
            session.setAttribute("teacherName",teacherName);
        }
        if(request.getParameter("id")!=null) {
            id = Integer.parseInt(request.getParameter("id"));
        }else{

            id = (int) session.getAttribute("deleteShowCourse");
        }
        List <Course> list = new ArrayList<>();
        TeachOperation teachOperation = new TeachOperation();
        try {
            list = teachOperation.getAllCourse(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        request.setAttribute("ID",id);
        RequestDispatcher rd = request.getRequestDispatcher("showCourse.jsp");
        rd.forward(request,response);
    }
}
