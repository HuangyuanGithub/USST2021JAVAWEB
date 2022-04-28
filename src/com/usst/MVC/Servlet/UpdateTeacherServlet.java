package com.usst.MVC.Servlet;

import com.usst.Dao.TeacherOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateTeacherServlet", value = "/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        TeacherOperation teacherOperation = new TeacherOperation();
        try {
            teacherOperation.deleteTeacher(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("AllTeacherServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int count=0;
        if(request.getParameter("id")!=""){
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String  position = request.getParameter("position");
            String detail = request.getParameter("detail");
            String password = request.getParameter("password");
            TeacherOperation TeacherOperation = new TeacherOperation();
            try {
                count=TeacherOperation.alterTeacher(id,username,password,position,detail);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{

            String username = request.getParameter("username");
            String  position = request.getParameter("position");
            String detail = request.getParameter("detail");
            String password = request.getParameter("password");
            TeacherOperation TeacherOperation = new TeacherOperation();
            try {
                count=TeacherOperation.addTeacher(username,password,position,detail);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        RequestDispatcher rd;
        if(count==0) {
             rd = request.getRequestDispatcher("dberror.jsp");
            rd.forward(request,response);
        }
        rd = request.getRequestDispatcher("AllTeacherServlet");
        rd.forward(request,response);

    }
}