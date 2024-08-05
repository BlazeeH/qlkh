/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnlineCourse;
import DAL.OnlineCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class OnlinecourseBLL {
   OnlineCourseDAL onlinec;
    public OnlinecourseBLL() {
        onlinec = new OnlineCourseDAL();
    }
    public List LoadOnline(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = onlinec.readOnlineCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
    public List findbyTitle(String Title) throws SQLException {
        List list = new ArrayList();

        list = onlinec.findbyTitle(Title);

        return list;

    }
    public OnlineCourse getOnline(int courseID) throws SQLException
    {
        OnlineCourse oc = onlinec.getOnlineCourse(courseID);
        return oc;
    }

    public int addOnline(OnlineCourse oc) throws SQLException {
        int result = onlinec.insertOnlineCourse(oc);
        return result;
    }

    public int updateOnline(OnlineCourse oc) throws SQLException {
        int result = onlinec.updateOnlineCourse(oc);
        return result;
    }
    public int deleteOnline(int courseID) throws SQLException {
        int result = onlinec.deleteOnlineCourse(courseID);
        return result;
    }
}
