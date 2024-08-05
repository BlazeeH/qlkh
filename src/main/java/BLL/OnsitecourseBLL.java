/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnlineCourse;
import DAL.OnsiteCourse;
import DAL.OnsiteCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OnsitecourseBLL {
    OnsiteCourseDAL onsitec;
    public OnsitecourseBLL() {
        onsitec = new OnsiteCourseDAL();
    }
    public List LoadOnsite(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = onsitec.readOnsiteCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
    public List findbyTitle(String Title) throws SQLException {
        List list = new ArrayList();

        list = onsitec.findbyTitle(Title);

        return list;

    }
    public OnsiteCourse getOnsite(int courseID) throws SQLException
    {
        OnsiteCourse oc = onsitec.getOnsiteCourse(courseID);
        return oc;
    }

    public int addOnsite(OnsiteCourse oc) throws SQLException {
        int result = onsitec.insertOnsiteCourse(oc);
        return result;
    }

    public int updateOnsite(OnsiteCourse oc) throws SQLException {
        int result = onsitec.updateOnsiteCourse(oc);
        return result;
    }
    public int deleteOnsite(int courseID) throws SQLException {
        int result = onsitec.deleteOnsiteCourse(courseID);
        return result;
    }
}
