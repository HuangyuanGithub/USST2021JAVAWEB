package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.Dao.MessageOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateMessageServlet", value = "/UpdateMessageServlet")
public class UpdateMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        MessageOperation messageOperation = new MessageOperation();
        try {
            messageOperation.deleteMessage(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("status").equals("admin")) {

            RequestDispatcher rd = request.getRequestDispatcher("AllMessageServlet");
            rd.forward(request, response);
        }else if(session.getAttribute("status").equals("student")) {


            RequestDispatcher rd = request.getRequestDispatcher("StudentAlterMessageServlet");
            rd.forward(request, response);
        }

        else{
            RequestDispatcher rd = request.getRequestDispatcher("TeacherDeleMessageServlet");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        MessageOperation messageOperation = new MessageOperation();
        try {
            messageOperation.alterMessage(id,title,text);
            messageOperation.reset(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();

        if(session.getAttribute("status").equals("admin")) {

            RequestDispatcher rd = request.getRequestDispatcher("AllMessageServlet");
            rd.forward(request, response);
        }else if(session.getAttribute("status").equals("student")) {


            RequestDispatcher rd = request.getRequestDispatcher("StudentAlterMessageServlet");
            rd.forward(request, response);
        }

        else{
            RequestDispatcher rd = request.getRequestDispatcher("TeacherDeleMessageServlet");
            rd.forward(request, response);
        }
    }
}
