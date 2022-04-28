package com.usst.MVC.Servlet;

import com.usst.Dao.TeachOperation;
import com.usst.Dao.TeacherOperation;
import com.usst.JavaBean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateTeachCourseServlet", value = "/UpdateTeachCourseServlet")
public class UpdateTeachCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        TeachOperation teachOperation = new TeachOperation();
        if(request.getParameter("ID")!=null) {
            int ID = Integer.parseInt(request.getParameter("ID"));
            try {
                teachOperation.deleteTeach(ID, id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession();
            session.setAttribute("deleteShowCourse", ID);
            response.sendRedirect("ShowCourseServlet");


        }else{
            String name = request.getParameter("name");
            List <Teacher> list = new ArrayList<>();
            try {
                list = teachOperation.getOtherTeacher(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("list",list);
            request.setAttribute("name",name);
            request.setAttribute("id",id);
            RequestDispatcher rd = request.getRequestDispatcher("teacherList.jsp");
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

        response.sendRedirect("ShowCourseServlet?id="+teacherId);


    }
}
