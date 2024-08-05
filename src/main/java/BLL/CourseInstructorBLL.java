/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseInstructor;
import DAL.CourseInstructorDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY COMPUTER
 */
public class CourseInstructorBLL {
     CourseInstructorDAL ci;
    public CourseInstructorBLL() {
        ci = new CourseInstructorDAL();
    }
    public List LoadCourseInstructor(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = ci.readCourseInstructor();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
     public int updateCourseIntstructor(CourseInstructor insupdate,CourseInstructor ins ) throws SQLException {
        int result = ci.updateCourseInstructor(insupdate, ins);
        return result;
    }
      public List findCourseIntstructor(String Title) throws SQLException {
        List list = new ArrayList();

        list = ci. findCourseInstructor(Title);

        return list;

    }
       public int insertCourseInstructor (CourseInstructor instructor) throws SQLException {
        int result = ci.insertCourseInstructor(instructor);
        return result;
    }
 public int deleteCourseInstructor(int CourseID ,int PersonID) throws SQLException {
        int result = ci.deleteCourseInstructor(CourseID,PersonID );
        return result;
}
     public CourseInstructor getCourseInstructor(int CourseID, int PersonID) throws SQLException
    {
        CourseInstructor st = ci.getCourseInstructor(CourseID, PersonID);
        return st;
    }

}
