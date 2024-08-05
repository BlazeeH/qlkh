/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author MY COMPUTER
 */
public class CourseInstructor {
    int CourseID;
    String Title;
    String firstName, lastName;
    int personID;

    public CourseInstructor() {
    }

    public CourseInstructor(int CourseID, String Title, String firstName, String lastName, int personID) {
        this.CourseID = CourseID;
        this.Title = Title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personID = personID;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personId) {
        this.personID = personId;
    }
    
}
