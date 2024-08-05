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
 * @author Admin
 */
public class OnlineCourseDAL extends MyDatabaseManager{
    public OnlineCourseDAL() {

        OnlineCourseDAL.connectDB();
    }

    public ArrayList readOnlineCourse() throws SQLException {
        String query = 
"SELECT onlinecourse.CourseID ,Title, Credits, department.Name, url, department.DepartmentID\n" +
"FROM onlinecourse, course, department\n" +
"WHERE onlinecourse.CourseID = course.CourseID AND course.DepartmentID = department.DepartmentID";
        ResultSet rs = OnlineCourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                OnlineCourse oc = new OnlineCourse();
                oc.setCourseID(rs.getInt("CourseID"));
                oc.setTitle(rs.getString("Title"));
                oc.setCredits(rs.getInt("Credits"));
                oc.setDepartmentName(rs.getString("Name"));
                oc.setDepartmentId(rs.getInt("DepartmentId"));
                oc.setUrl(rs.getString("url"));  
                list.add(oc);
            }
        }
        return list;
    }
    public OnlineCourse getOnlineCourse(int onlinecourseID) throws SQLException {

        String query = 
"SELECT onlinecourse.CourseID ,Title, Credits, department.Name, department.DepartmentID, url\n" +
"FROM onlinecourse, course, department\n" +
"WHERE onlinecourse.CourseID = course.CourseID AND course.DepartmentID = department.DepartmentID "
                + "AND onlinecourse.CourseID  = ? ";

        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, onlinecourseID );
        ResultSet rs = p.executeQuery();
        
        OnlineCourse oc = new OnlineCourse();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                oc.setCourseID(rs.getInt("CourseID"));
                oc.setTitle(rs.getString("Title"));
                oc.setCredits(rs.getInt("Credits"));
                oc.setDepartmentName(rs.getString("Name"));
                oc.setDepartmentId(rs.getInt("DepartmentId"));
                oc.setUrl(rs.getString("url"));
            }
        }
        return oc;

    }

    public int updateOnlineCourse(OnlineCourse oc) throws SQLException {
        String query = "Update onlinecourse SET url = ?"
                + " WHERE CourseID = ?";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setString(1, oc.getUrl());
        p.setInt(2, oc.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertOnlineCourse(OnlineCourse oc) throws SQLException {
        String query = "INSERT INTO onlinecourse (CourseID, url) VALUES (?, ?)";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, oc.getCourseID());
        p.setString(2, oc.getUrl());
        int result = p.executeUpdate();
        return result;
    }

    public List findbyTitle(String Title) throws SQLException {
        String query =  
            "SELECT onlinecourse.CourseID ,Title, Credits, department.Name, department.DepartmentID, url\n" +
            "FROM onlinecourse, course, department\n" +
            "WHERE onlinecourse.CourseID = course.CourseID AND course.DepartmentID = department.DepartmentID "
            + "AND  course.Title LIKE ?";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setString(1, "%" + Title + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                OnlineCourse oc = new OnlineCourse();
                oc.setCourseID(rs.getInt("CourseID"));
                oc.setTitle(rs.getString("Title"));
                oc.setCredits(rs.getInt("Credits"));
                oc.setDepartmentName(rs.getString("Name"));
                oc.setDepartmentId(rs.getInt("DepartmentId"));
                oc.setUrl(rs.getString("url"));
                list.add(oc);
            }
        }
        return list;
    }

    public int deleteOnlineCourse(int courseID) throws SQLException {
        String query = "DELETE FROM onlinecourse WHERE courseID = ?";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();

        return result;
    }
}
