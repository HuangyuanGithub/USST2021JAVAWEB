package com.usst.MVC.Servlet;

import com.usst.Dao.MessageOperation;
import com.usst.JavaBean.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentNewServlet", value = "/StudentNewServlet")
public class StudentNewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        int count=0;
        MessageOperation messageOperation = new MessageOperation();
        HttpSession session = request.getSession();
        try {
            count = messageOperation.studentAllNew((Integer) session.getAttribute("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("count",count);
        RequestDispatcher rd = request.getRequestDispatcher("studentPage.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        MessageOperation messageOperation =new  MessageOperation();
        List<Message> list = new ArrayList<>();
        HttpSession session = request.getSession();
        try {
            list = messageOperation.studentAllNewMessage((Integer) session.getAttribute("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        RequestDispatcher rd = request.getRequestDispatcher("StudentAnswer.jsp");
        rd.forward(request,response);



    }
}
