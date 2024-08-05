/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY COMPUTER
 */
public class StudentGradeDAL extends  MyDatabaseManager{
   public StudentGradeDAL() {

        StudentGradeDAL.connectDB();
    }

    public ArrayList readStudentGrade() throws SQLException {
        String query = "SELECT * FROM Studentgrade WHERE EnrollmentID >0";
        ResultSet rs = StudentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                StudentGrade st = new StudentGrade();
                st.setEnrollmentID(rs.getInt("EnrollmentID"));
                st.setStudentID(rs.getInt("StudentID"));
                st.setCourseID(rs.getInt("CourseID"));
                st.setGrade(rs.getFloat("Grade")); 
                list.add(st);
            }
        }
        return list;
    }
    public StudentGrade getStudentGrade(int enrollmentID) throws SQLException {

        String query = "SELECT * FROM studentgrade WHERE Grade >0 AND EnrollmentID = ? ";


        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, enrollmentID );
        ResultSet rs = p.executeQuery();
        
        StudentGrade st = new StudentGrade();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                st.setEnrollmentID(rs.getInt("EnrollmentID"));
                st.setStudentID(rs.getInt("StudentID"));
                st.setCourseID(rs.getInt("CourseID"));
                st.setGrade(rs.getFloat("Grade")); 
            }
        }
        return st;

    }

    public int updateStudentGrade(StudentGrade st) throws SQLException {
        String query ="Update studentgrade SET StudentID = ? , CourseID = ?, Grade=? "
                + " WHERE  EnrollmentID = ?";

        PreparedStatement p = StudentGradeDAL.connectDB().prepareStatement(query);
        p.setInt(1,st.getStudentID());
        p.setInt(2,st.getCourseID());
        p.setFloat(3,st.getGrade());
        p.setInt(4,st.getEnrollmentID());
           
      
        int result = p.executeUpdate();
        return result;
    }

    public int insertStudenyGrade(StudentGrade st) throws SQLException {
        String query = "Insert StudentGrade (EnrollmentID, StudentID, CourseID, Grade) VALUES (?, ?, ?,?)";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1,st.getEnrollmentID());
        p.setInt(2,st.getStudentID());
        p.setInt(3,st.getCourseID());
        p.setFloat(4,st.getGrade());
        int result = p.executeUpdate();
        return result;
    }

    public List findStudentGrade(String ErollmentID) throws SQLException {
        String query =  
                "SELECT * FROM studentgrade WHERE  EnrollmentID LIKE ?";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setString(1, "%" + ErollmentID + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                StudentGrade st = new StudentGrade();
                st.setEnrollmentID(rs.getInt("EnrollmentID"));
                st.setStudentID(rs.getInt("StudentID"));
                st.setCourseID(rs.getInt("CourseID"));
                st.setGrade(rs.getFloat("Grade")); 
                list.add(st);
            }
        }
        return list;
    }

    public int deleteStudentGrade(int EnrollmentID) throws SQLException {
        String query = "DELETE FROM studentgrade WHERE EnrollmentID = ?";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, EnrollmentID);
        int result = p.executeUpdate();

        return result;
    }

   
}
