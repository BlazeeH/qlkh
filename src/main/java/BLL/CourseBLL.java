/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Course;
import DAL.CourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CourseBLL {
    CourseDAL course;
    public CourseBLL() {
        course = new CourseDAL();
    }
    public List LoadCourse(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = course.readCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
    public Course getCourse(int courseID) throws SQLException
    {
        Course oc = course.getCourse(courseID);
        return oc;
    }
}
