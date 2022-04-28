package com.usst.MVC.Servlet;

import com.usst.Dao.CollegeOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllCollegeServlet", value = "/AllCollegeServlet")
public class AllCollegeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        List collegeList = new ArrayList();
        CollegeOperation collegeOperation=new CollegeOperation();
        try {
            collegeList = collegeOperation.getAllCollege();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("collegeList",collegeList);


        HttpSession session = request.getSession();

        if(session.getAttribute("status").equals("admin")){
            RequestDispatcher rd = request.getRequestDispatcher("alterCourse.jsp");
            rd.forward(request,response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("chooseCollege.jsp");
            rd.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List collegeList = new ArrayList();
        CollegeOperation collegeOperation=new CollegeOperation();
        try {
            collegeList = collegeOperation.getAllCollege();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("collegeList",collegeList);
        HttpSession session = request.getSession();
        if(session.getAttribute("status").equals("admin")){
            RequestDispatcher rd = request.getRequestDispatcher("collegeView.jsp");
            rd.forward(request,response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("chooseCollege.jsp");
            rd.forward(request,response);
        }


    }
}
