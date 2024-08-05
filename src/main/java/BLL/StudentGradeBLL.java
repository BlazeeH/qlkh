/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudentGrade;
import DAL.StudentGradeDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY COMPUTER
 */
public class StudentGradeBLL {
    StudentGradeDAL studentgrade;
    public StudentGradeBLL() {
        studentgrade = new StudentGradeDAL();
    }
    public List LoadStudentGrade(int page) throws SQLException {
        int numofrecords = 100;
        ArrayList list = studentgrade.readStudentGrade();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
    public List findStudentGrade(String EnrollmentID) throws SQLException {
        List list = new ArrayList();

        list = studentgrade.findStudentGrade(EnrollmentID);

        return list;

    }
    public StudentGrade getStudentGrade(int enrollmentID) throws SQLException
    {
        StudentGrade st = studentgrade.getStudentGrade(enrollmentID);
        return st;
    }

    public int insertStudenyGrade (StudentGrade st) throws SQLException {
        int result = studentgrade.insertStudenyGrade(st);
        return result;
    }

    public int updateStudentGrade(StudentGrade st) throws SQLException {
        int result = studentgrade.updateStudentGrade(st);
        return result;
    }
    public int deleteStudentGrade(int ErollmentID) throws SQLException {
        int result = studentgrade.deleteStudentGrade(ErollmentID);
        return result;
    }

    
   
  
}
