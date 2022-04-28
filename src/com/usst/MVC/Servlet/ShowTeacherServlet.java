package com.usst.MVC.Servlet;

import com.usst.Dao.TeacherOperation;
import com.usst.Dao.TeachOperation;
import com.usst.JavaBean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowTeacherServlet", value = "/ShowTeacherServlet")
public class ShowTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id;
        HttpSession session = request.getSession();
        if(session.getAttribute("courseName")==null||(!session.getAttribute("courseName").equals(request.getParameter("name"))&&request.getParameter("name")!=null)) {
            String courseName = request.getParameter("name");
            session.setAttribute("courseName",courseName);
        }
        if(request.getParameter("id")!=null) {
            id = Integer.parseInt(request.getParameter("id"));
        }else{

            id = (int) session.getAttribute("deleteShowTeacher");
        }
        List <Teacher> list = new ArrayList<>();
        TeachOperation teachOperation = new TeachOperation();
        try {
            list = teachOperation.getAllTeacher(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        request.setAttribute("ID",id);

        RequestDispatcher rd = request.getRequestDispatcher("showTeacher.jsp");
        rd.forward(request,response);
    }
}

