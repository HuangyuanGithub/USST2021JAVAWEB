package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.JavaBean.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateCourseServlet", value = "/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        CourseOperation courseOperation = new CourseOperation();
        try {
            courseOperation.deleteCourse(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("AllCourseServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CourseOperation courseOperation;
        int count=0;
        if(request.getParameter("id")!=""){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String collegeName = request.getParameter("collegeName");
            String detail = request.getParameter("detail");
            courseOperation = new CourseOperation();
            try {
                count=courseOperation.alterCourse(id,name,collegeName,detail);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{

            String name = request.getParameter("name");
            String collegeName = request.getParameter("collegeName");
            String detail = request.getParameter("detail");
            courseOperation = new CourseOperation();
            try {
                count=courseOperation.addCourse(name,collegeName,detail);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        RequestDispatcher rd;
        if(count==0) {
            rd = request.getRequestDispatcher("dberror.jsp");
            rd.forward(request,response);
        }
        rd = request.getRequestDispatcher("AllCourseServlet");
        rd.forward(request,response);

    }
}