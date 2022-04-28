package com.usst.MVC.Servlet;

import com.usst.Dao.MessageOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentAlterMessageServlet", value = "/StudentAlterMessageServlet")
public class StudentAlterMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List messageList = new ArrayList();
        MessageOperation messageOperation = new MessageOperation();
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        try {
            messageList = messageOperation.getMyMessage(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("messageList",messageList);
        RequestDispatcher rd = request.getRequestDispatcher("messageView.jsp");
        rd.forward(request,response);
    }
}

