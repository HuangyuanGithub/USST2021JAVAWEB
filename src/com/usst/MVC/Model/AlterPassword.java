package com.usst.MVC.Model;

import com.usst.Dao.AdminOperation;
import com.usst.Dao.StudentOperation;
import com.usst.Dao.TeacherOperation;

public class AlterPassword {

    public void alterPassword(String username,String password,String status) throws Exception {
        if(status.equals("admin")){
            AdminOperation adminOperation = new AdminOperation();
            adminOperation.alterAdmin(password);

        }
        else if(status.equals("teacher")){
            TeacherOperation teacherOperation = new TeacherOperation();
            teacherOperation.alterTeacherPassword(username,password);
        }
        else{
            StudentOperation studentOperation = new StudentOperation();
            studentOperation.alterStudentPassword(username,password);

        }


    }

}
