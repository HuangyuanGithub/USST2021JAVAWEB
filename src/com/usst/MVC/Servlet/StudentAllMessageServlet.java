package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.Dao.MessageOperation;
import com.usst.Dao.TeacherOperation;
import com.usst.JavaBean.Course;
import com.usst.JavaBean.Message;
import com.usst.JavaBean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentAllMessageServlet", value = "/StudentAllMessageServlet")
public class StudentAllMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        MessageOperation messageOperation = new MessageOperation();
        List<Message> messageList = new ArrayList<>();
        String keyword=null;


        if(request.getParameter("keyword")==null) {
            try {
                messageList = messageOperation.getAllSearchMessages();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            keyword = request.getParameter("keyword");
            keyword = '%'+keyword+"%";
            try {
                messageList = messageOperation.getAllSearchMessage(keyword,keyword,keyword,keyword,keyword);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(keyword!=null){
            keyword=keyword.replace("%","");
            keyword=keyword.trim();
        }
        request.setAttribute("messageList",messageList);
        request.setAttribute("keyword",keyword);
        RequestDispatcher rd = request.getRequestDispatcher("StudentAllMessage.jsp");
        rd.forward(request,response);



    }
}