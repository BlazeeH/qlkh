/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author MY COMPUTER
 */
public class StudentGrade {
    int EnrollmentID;
    float Grade;
    int StudentID;
     int CourseID;

    public StudentGrade() {
    }

    public StudentGrade(int EnrollmentID, float Grade, int StudentID, int CourseID) {
        this.EnrollmentID = EnrollmentID;
        this.Grade = Grade;
        this.StudentID = StudentID;
        this.CourseID = CourseID;
    }

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public float getGrade() {
        return Grade;
    }

    public void setGrade(float Grade) {
        this.Grade = Grade;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

}
