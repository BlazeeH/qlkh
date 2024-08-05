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
public class OnsiteCourse extends Course{	
    String Location;	
    String Days;	
    Time Time;

    public OnsiteCourse() {
    }

    public OnsiteCourse(String Location, String Days, Time Time, int CourseID, String Title, int Credits, int DepartmentId, String DepartmentName) {
        super(CourseID, Title, Credits, DepartmentId, DepartmentName);
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

    
}
