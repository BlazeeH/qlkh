/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Admin
 */
public class Course {
    int CourseID;
    String Title;
    int Credits;
    int DepartmentId;
    String DepartmentName;

    public Course() {
    }

    public Course(int CourseID, String Title, int Credits, int DepartmentId, String DepartmentName) {
        this.CourseID = CourseID;
        this.Title = Title;
        this.Credits = Credits;
        this.DepartmentId = DepartmentId;
        this.DepartmentName = DepartmentName;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
    
    
}
