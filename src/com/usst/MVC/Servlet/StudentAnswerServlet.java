package com.usst.MVC.Servlet;

import com.usst.Dao.MessageOperation;
import com.usst.JavaBean.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentAnswerServlet", value = "/StudentAnswerServlet")
public class StudentAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        MessageOperation messageOperation = new MessageOperation();
        List<Message> list = new ArrayList<>();
        try {
            list = messageOperation.studentToNewMessage(id);
            messageOperation.alterFlag(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        RequestDispatcher rd = request.getRequestDispatcher("studentToAnswer.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}