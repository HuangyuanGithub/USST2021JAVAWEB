package com.usst.MVC.Servlet;

import com.usst.Dao.TeachOperation;
import com.usst.Dao.TeacherOperation;
import com.usst.JavaBean.Course;
import com.usst.JavaBean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateTeachTeacherServlet", value = "/UpdateTeachTeacherServlet")
public class UpdateTeachTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        TeachOperation teachOperation = new TeachOperation();

        if (request.getParameter("ID") != null) {
            int ID = Integer.parseInt(request.getParameter("ID"));

            try {
                teachOperation.deleteTeach(id, ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession();
            session.setAttribute("deleteShowTeacher", ID);
            response.sendRedirect("ShowTeacherServlet");
        }else{
            String name = request.getParameter("name");
            List<Course> list = new ArrayList<>();
            try {
                list = teachOperation.getOtherCourse(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("list",list);
            request.setAttribute("name",name);
            request.setAttribute("id",id);
            RequestDispatcher rd = request.getRequestDispatcher("courseList.jsp");
            rd.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        TeachOperation teachOperation = new TeachOperation();
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        try {
            teachOperation.addTeach(teacherId,courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("ShowTeacherServlet?id="+courseId);


    }


}
