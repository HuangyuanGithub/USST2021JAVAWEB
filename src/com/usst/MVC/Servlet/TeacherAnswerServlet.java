package com.usst.MVC.Servlet;

import com.usst.Dao.CollegeOperation;
import com.usst.Dao.MessageOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TeacherAnswerServlet", value = "/TeacherAnswerServlet")
public class TeacherAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        if(request.getParameter("id")==null){
            doPost(request, response);
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            MessageOperation messageOperation = new MessageOperation();
            List messageList = new ArrayList();
            try {
                messageList = messageOperation.getAnswer(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("list",messageList);
            RequestDispatcher rd = request.getRequestDispatcher("alterAnswer.jsp");
            rd.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        List messageList = new ArrayList();
        HttpSession session = request.getSession();
        MessageOperation messageOperation = new MessageOperation();
        try {
            messageList = messageOperation.getAllAnswer((Integer) session.getAttribute("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("search","-1");
        request.setAttribute("list",messageList);
        RequestDispatcher rd = request.getRequestDispatcher("teacherAnswerMessage.jsp");
        rd.forward(request,response);



    }
}
