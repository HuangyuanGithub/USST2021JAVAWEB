package com.usst.MVC.Servlet;

import com.usst.Dao.MessageOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateAnswerServlet", value = "/UpdateAnswerServlet")
public class UpdateAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        MessageOperation messageOperation = new MessageOperation();
        try {
            messageOperation.deleteAnswer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("TeacherAnswerServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String answer = request.getParameter("answer");
        int id = Integer.parseInt(request.getParameter("id"));
        MessageOperation messageOperation = new MessageOperation();
        HttpSession session = request.getSession();
        int teacherId = (int) session.getAttribute("id");
        try {
            messageOperation.addAnswer(id,answer,teacherId);
            //messageOperation.teacherreset(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(session.getAttribute("search")==null||session.getAttribute("search").equals("-1")){
            response.sendRedirect("TeacherAnswerServlet");
        }else{
            response.sendRedirect("TeacherCourseAnswerServlet");
        }

    }
}
