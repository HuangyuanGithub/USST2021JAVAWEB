package com.usst.MVC.Servlet;

import com.usst.Dao.ExcludeOperation;
import com.usst.Dao.MessageOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllExcludeServlet", value = "/AllExcludeServlet")
public class AllExcludeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List excludeList = new ArrayList();
        HttpSession session = request.getSession();
        ExcludeOperation excludeOperation = new ExcludeOperation();
        try {
            excludeList = excludeOperation.getAllExclude((Integer) session.getAttribute("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("excludeList",excludeList);
        RequestDispatcher rd = request.getRequestDispatcher("excludeView.jsp");
        rd.forward(request,response);
    }
}
