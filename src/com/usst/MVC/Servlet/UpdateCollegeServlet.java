package com.usst.MVC.Servlet;

import com.usst.Dao.CollegeOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCollegeServlet", value = "/UpdateCollegeServlet")
public class UpdateCollegeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int idx= Integer.parseInt(request.getParameter("id"));
        CollegeOperation collegeOperation = new CollegeOperation();
        try {
            collegeOperation.deleCollege(idx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("AllCollegeServlet");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int count=0;
        if(request.getParameter("id")!=""){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String old = request.getParameter("old");
            CollegeOperation collegeOperation = new CollegeOperation();
            try {
                count=collegeOperation.alterCollege(id,name);
                collegeOperation.alterall(name,old);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{

            String name = request.getParameter("name");
            CollegeOperation collegeOperation = new CollegeOperation();
            try {
                count=collegeOperation.addCollege(name);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        RequestDispatcher rd;
        if(count==0) {
            rd = request.getRequestDispatcher("dberror.jsp");
            rd.forward(request,response);
        }
        rd = request.getRequestDispatcher("AllCollegeServlet");
        rd.forward(request,response);

    }
}