/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Time;

/**
 *
 * @author Admin
 */
public class OnlineCourse extends Course{
    	
    String url;

    public OnlineCourse() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OnlineCourse(String url, int CourseID, String Title, int Credits, int DepartmentId, String DepartmentName) {
        super(CourseID, Title, Credits, DepartmentId, DepartmentName);
        this.url = url;
    }
    
}
