package com.usst.MVC.Servlet;

import com.usst.Dao.AdminOperation;
import com.usst.Dao.StudentOperation;
import com.usst.Dao.TeacherOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        AdminOperation adminOperation = new AdminOperation();
        int flag = 0;
        try {
            flag = adminOperation.checkAdmin(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (username.equals("admin") && flag > 0) {
            session.setAttribute("status", "admin");
            RequestDispatcher rd = request.getRequestDispatcher("adminsterPage.jsp");
            rd.forward(request, response);
        } else {
            TeacherOperation teacherOperation = new TeacherOperation();

            try {
                flag = teacherOperation.checkTeacher(username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flag > 0) {
                session.setAttribute("status", "teacher");
                session.setAttribute("id",flag);
                response.sendRedirect("TeacherNewServlet");

            } else {
                StudentOperation studentOperation = new StudentOperation();
                try {
                    flag = studentOperation.checkStudent(username, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (flag > 0) {
                    session.setAttribute("status", "student");
                    session.setAttribute("id",flag);
                    response.sendRedirect("StudentNewServlet");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                    rd.forward(request, response);
                }
            }
        }
    }
}