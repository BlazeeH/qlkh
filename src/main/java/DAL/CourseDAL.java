/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CourseDAL extends MyDatabaseManager {
    public CourseDAL() {

        CourseDAL.connectDB();
    }

    public ArrayList readCourse() throws SQLException {
        String query = "SELECT * FROM course , department WHERE course.DepartmentID = department.DepartmentID";
        ResultSet rs = CourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Course s = new Course();
                s.setCourseID(rs.getInt("CourseID"));
                s.setTitle(rs.getString("Title"));
                s.setCredits(rs.getInt("Credits"));
                s.setDepartmentId(rs.getInt("DepartmentID"));
                s.setDepartmentName(rs.getString("Name"));
                list.add(s);
            }
        }
        return list;
    }

    public Course getCourse(int courseID) throws SQLException {

        String query = "SELECT * FROM course , department WHERE course.DepartmentID = department.DepartmentID AND CourseID  = ? ";

        PreparedStatement p = CourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, courseID );
        ResultSet rs = p.executeQuery();
        
        Course s = new Course();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {             
                s.setCourseID(rs.getInt("CourseID"));
                s.setTitle(rs.getString("Title"));
                s.setCredits(rs.getInt("Credits"));
                s.setDepartmentId(rs.getInt("DepartmentID"));
                s.setDepartmentName(rs.getString("Name"));
            }
        }
        return s;

    }

    public int updateCourse(Course s) throws SQLException {
        String query = "Update course SET Title = ? , Credits = ? , DepartmentID = ? "
                + " WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.connectDB().prepareStatement(query);
        p.setString(1, s.getTitle());
        p.setInt(2, s.getCredits());
        p.setInt(3, s.getDepartmentId());
        p.setInt(4, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertCourse(Course s) throws SQLException {
        String query = "Insert course (CourseID, Title, Credits, DepartmentID) VALUES (?, ?, ?, ?)";
        PreparedStatement p = CourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, s.getCourseID());
        p.setString(2, s.getTitle());
        p.setInt(3, s.getCredits());
        p.setInt(3, s.getDepartmentId());
        int result = p.executeUpdate();
        return result;
    }

    public List findCourses(String courseID) throws SQLException {
        String query = "SELECT * FROM course WHERE  CourseID LIKE ?";
        PreparedStatement p = CourseDAL.connectDB().prepareStatement(query);
        p.setString(1, "%" + courseID + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Course s = new Course();
                s.setCourseID(rs.getInt("CourseID"));
                s.setTitle(rs.getString("Title"));
                s.setCredits(rs.getInt("Credits"));
                s.setDepartmentId(rs.getInt("DepartmentID"));
                list.add(s);
            }
        }
        return list;
    }

    public int deleteCourse(int courseID) throws SQLException {
        String query = "DELETE FROM course WHERE courseID = ?";
        PreparedStatement p = CourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();

        return result;
    }
}
