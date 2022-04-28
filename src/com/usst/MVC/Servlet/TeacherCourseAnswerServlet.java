package com.usst.MVC.Servlet;

import com.usst.Dao.MessageOperation;
import com.usst.JavaBean.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TeacherCourseAnswerServlet", value = "/TeacherCourseAnswerServlet")
public class TeacherCourseAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        int id=0;
        if(request.getParameter("id")!=null) {
           id = Integer.parseInt(request.getParameter("id"));
            session.setAttribute("search",id);
        }
        else{
            id= (int) session.getAttribute("search");
        }
        List<Message> list = new ArrayList<>();
        MessageOperation messageOperation = new MessageOperation();

        try {
            list = messageOperation.getCourseMessage((Integer) session.getAttribute("id"),id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        RequestDispatcher rd = request.getRequestDispatcher("teacherCourseAnswerServlet.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}