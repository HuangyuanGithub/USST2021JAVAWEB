package com.usst.MVC.Servlet;

import com.usst.Dao.AdminOperation;
import com.usst.Dao.StudentOperation;
import com.usst.Dao.TeacherOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flag=0;
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        StudentOperation studentOperation = new StudentOperation();
        try {
            flag=studentOperation.checkStudentRegister(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher rd;
        if(flag>0||username.equals("admin")) {
            rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            try {
                studentOperation.addStudent(username,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                flag=studentOperation.checkStudentRegister(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("id", flag);

            session.setAttribute("status", "student");
            rd = request.getRequestDispatcher("studentPage.jsp");
            rd.forward(request, response);
        }
    }
}