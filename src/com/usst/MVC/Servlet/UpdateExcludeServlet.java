package com.usst.MVC.Servlet;

import com.usst.Dao.ExcludeOperation;
import com.usst.Dao.StudentOperation;
import com.usst.JavaBean.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateExcludeServlet", value = "/UpdateExcludeServlet")
public class UpdateExcludeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        if(request.getParameter("id")!=null){
            int id= Integer.parseInt(request.getParameter("id"));
            ExcludeOperation excludeOperation = new ExcludeOperation();
            try {
                excludeOperation.deleExclude(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("AllExcludeServlet");
        }else{
            List<Student> list=new ArrayList<>();
            StudentOperation studentOperation = new StudentOperation();
            try {
                list=studentOperation.getAllStudent();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("list",list);
            RequestDispatcher rd = request.getRequestDispatcher("alterExclude.jsp");
            rd.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        HttpSession session = request.getSession();
        int teacherId = (int) session.getAttribute("id");
        ExcludeOperation excludeOperation = new ExcludeOperation();
        try {
            excludeOperation.addExclude(studentId,teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("AllExcludeServlet");



    }
}
