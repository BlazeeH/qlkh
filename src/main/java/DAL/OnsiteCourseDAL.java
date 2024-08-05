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
public class OnsiteCourseDAL extends MyDatabaseManager{
    public OnsiteCourseDAL() {

        OnsiteCourseDAL.connectDB();
    }

    public ArrayList readOnsiteCourse() throws SQLException {
        String query = 
"SELECT onsitecourse.CourseID ,Title, Credits,department.DepartmentID, department.Name,\n" +
"onsitecourse.Location,onsitecourse.Days,onsitecourse.Time \n" +
"FROM onsitecourse, course, department\n" +
"WHERE onsitecourse.CourseID = course.CourseID AND course.DepartmentID = department.DepartmentID ";
        ResultSet rs = OnsiteCourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                OnsiteCourse oc = new OnsiteCourse();
                oc.setCourseID(rs.getInt("CourseID"));
                oc.setTitle(rs.getString("Title"));
                oc.setCredits(rs.getInt("Credits"));
                oc.setDepartmentName(rs.getString("Name"));
                oc.setDepartmentId(rs.getInt("DepartmentId"));
                oc.setLocation(rs.getString("Location"));
                oc.setDays(rs.getString("Days"));
                oc.setTime(rs.getTime("Time"));
                list.add(oc);
            }
        }
        return list;
    }

    public OnsiteCourse getOnsiteCourse(int courseID) throws SQLException {

        String query = 
"SELECT onsitecourse.CourseID ,Title, Credits,department.DepartmentID, department.Name,\n" +
"onsitecourse.Location,onsitecourse.Days,onsitecourse.Time \n" +
"FROM onsitecourse, course, department\n" +
"WHERE onsitecourse.CourseID = course.CourseID AND course.DepartmentID = department.DepartmentID AND onsitecourse.CourseID  = ? ";

        PreparedStatement p = OnsiteCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, courseID );
        ResultSet rs = p.executeQuery();
        
        OnsiteCourse oc = new OnsiteCourse();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                oc.setCourseID(rs.getInt("CourseID"));
                oc.setTitle(rs.getString("Title"));
                oc.setCredits(rs.getInt("Credits"));
                oc.setDepartmentName(rs.getString("Name"));
                oc.setDepartmentId(rs.getInt("DepartmentId"));
                oc.setLocation(rs.getString("Location"));
                oc.setDays(rs.getString("Days"));
                oc.setTime(rs.getTime("Time"));
            }
        }
        return oc;

    }

    public int updateOnsiteCourse(OnsiteCourse oc) throws SQLException {
        String query = "UPDATE onsitecourse SET "
                + "Location=?,"
                + "Days=?,"
                + "Time=? "
                + "WHERE CourseID=?";
        PreparedStatement p = OnsiteCourseDAL.connectDB().prepareStatement(query);
        p.setString(1, oc.getLocation());
        p.setString(2, oc.getDays());
        p.setTime(3, oc.getTime());
        p.setInt(4, oc.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertOnsiteCourse(OnsiteCourse oc) throws SQLException {
        String query = "INSERT INTO onsitecourse(CourseID, Location, Days, Time) VALUES (?, ?, ?, ?)";
        PreparedStatement p = OnsiteCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, oc.getCourseID());
        p.setString(2, oc.getLocation());
        p.setString(3, oc.getDays());
        p.setTime(4, oc.getTime());
        int result = p.executeUpdate();
        return result;
    }

    public List findbyTitle(String Title) throws SQLException {
        String query = 
"SELECT onsitecourse.CourseID ,Title, Credits,department.DepartmentID, department.Name,\n" +
"onsitecourse.Location,onsitecourse.Days,onsitecourse.Time \n" +
"FROM onsitecourse, course, department\n" +
"WHERE onsitecourse.CourseID = course.CourseID AND course.DepartmentID = department.DepartmentID AND course.Title LIKE ?";
        PreparedStatement p = OnsiteCourseDAL.connectDB().prepareStatement(query);
        p.setString(1, "%" + Title + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                OnsiteCourse oc = new OnsiteCourse();
                oc.setCourseID(rs.getInt("CourseID"));
                oc.setTitle(rs.getString("Title"));
                oc.setCredits(rs.getInt("Credits"));
                oc.setDepartmentName(rs.getString("Name"));
                oc.setDepartmentId(rs.getInt("DepartmentId"));
                oc.setLocation(rs.getString("Location"));
                oc.setDays(rs.getString("Days"));
                oc.setTime(rs.getTime("Time"));
                list.add(oc);
            }
        }
        return list;
    }

    public int deleteOnsiteCourse(int courseID) throws SQLException {
        String query = "DELETE FROM onsitecourse WHERE courseID = ?";
        PreparedStatement p = OnsiteCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();

        return result;
    }
}
