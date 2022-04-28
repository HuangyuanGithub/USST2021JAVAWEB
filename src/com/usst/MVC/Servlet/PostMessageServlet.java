package com.usst.MVC.Servlet;

import com.usst.Dao.CourseOperation;
import com.usst.Dao.MessageOperation;
import com.usst.JavaBean.Course;
import com.usst.MVC.Model.Operation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PostMessageServlet", value = "/PostMessageServlet")
public class PostMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        List<Course> list = new ArrayList<>();
        CourseOperation courseOperation = new CourseOperation();
        try {
            list = courseOperation.getCourseName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        RequestDispatcher rd = request.getRequestDispatcher("postMessage.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String text = request.getParameter("text");
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        long time = session.getLastAccessedTime();
        Operation operation = new Operation();
        String date = operation.changeTime(time);

        MessageOperation messageOperation = new MessageOperation();
        try {
            messageOperation.addMessage(courseId,id,title,text,date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("StudentNewServlet");
    }
}