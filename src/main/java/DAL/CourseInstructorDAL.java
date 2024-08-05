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
public class CourseInstructorDAL extends MyDatabaseManager{
      public CourseInstructorDAL() {

       CourseInstructorDAL.connectDB();
    }

      public ArrayList readCourseInstructor() throws SQLException {
        String query = "SELECT courseinstructor.CourseID ,course.Title,  person.PersonID, Lastname, Firstname\n" +
                       "FROM courseinstructor, course, person\n" +
                       "WHERE courseinstructor.CourseID = course.CourseID AND Person.PersonID = courseinstructor.PersonID";

        ResultSet rs =CourseInstructorDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                CourseInstructor ci = new  CourseInstructor();
                ci.setCourseID(rs.getInt("CourseID"));
                ci.setTitle(rs.getString("Title"));
                ci.setPersonID(rs.getInt("PersonID"));
                ci.setLastName(rs.getString("Lastname"));
                ci.setFirstName(rs.getString("Firstname"));
                
                list.add(ci);
      
            }
        }
        return list;
}
      public CourseInstructor getCourseInstructor(int courseID, int personID) throws SQLException {


             String query =  "SELECT courseinstructor.CourseID ,course.Title,  person.PersonID, person.Lastname,person.Firstname\n" +
"FROM courseinstructor, course, person\n" +
"WHERE courseinstructor.CourseID = course.CourseID AND Person.PersonID = courseinstructor.PersonID AND courseinstructor.CourseID =  ? AND courseinstructor.PersonID =  ?"; 

        PreparedStatement p = CourseInstructorDAL.connectDB().prepareStatement(query);
        p.setInt(1, courseID );
        p.setInt(2, personID );
        ResultSet rs = p.executeQuery();    
        CourseInstructor ci = new  CourseInstructor();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
               ci.setCourseID(rs.getInt("CourseID"));
                ci.setTitle(rs.getString("Title"));
                ci.setPersonID(rs.getInt("PersonID"));
                ci.setLastName(rs.getString("Lastname"));
                ci.setFirstName(rs.getString("Firstname"));
                
            }
        }
        return ci;

    }
        public int updateCourseInstructor(CourseInstructor ciupdate, CourseInstructor ci ) throws SQLException {
        String query ="UPDATE `courseinstructor` SET `CourseID`=?,`PersonID`=? WHERE  `CourseID`= ? AND`PersonID`=?";

        PreparedStatement p = CourseInstructorDAL.connectDB().prepareStatement(query);
        p.setInt(1,ciupdate.getCourseID());
        p.setInt(2,ciupdate.getPersonID());
        p.setInt(3,ci.getCourseID());
        p.setInt(4,ci.getPersonID());
        int result = p.executeUpdate();
        return result;
    }
        public int insertCourseInstructor(CourseInstructor ci) throws SQLException {
        String query = "Insert CourseInstructor ( CourseID,  PersonID) VALUES (?, ?)";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
         p.setInt(1,ci.getCourseID());
        p.setInt(2,ci.getPersonID());
        int result = p.executeUpdate();
        return result;
    }
         public List findCourseInstructor(String Title) throws SQLException {
        String query =  
                "SELECT courseinstructor.CourseID ,course.Title,  person.PersonID, person.Lastname,person.Firstname\n"+
                "FROM courseinstructor, course, person\n" +
                "WHERE courseinstructor.CourseID = course.CourseID AND Person.PersonID = courseinstructor.PersonID " 
                + "AND course.Title LIKE ? ";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setString(1, "%" + Title + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                CourseInstructor ci = new  CourseInstructor();
                ci.setCourseID(rs.getInt("CourseID"));
                ci.setTitle(rs.getString("Title"));
                ci.setPersonID(rs.getInt("PersonID"));
                ci.setLastName(rs.getString("Lastname"));
                ci.setFirstName(rs.getString("Firstname"));
              
                list.add(ci);
            }
        }
        return list;
    }

    public int deleteCourseInstructor(int CourseID, int PersonID) throws SQLException {
        String query = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID= ? ";
        PreparedStatement p = OnlineCourseDAL.connectDB().prepareStatement(query);
        p.setInt(1, CourseID);
        p.setInt(2, PersonID);
        int result = p.executeUpdate();

        return result;
    }

}
