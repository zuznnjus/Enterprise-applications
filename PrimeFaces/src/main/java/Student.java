/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Student {
    private String name;
    private String surname;
    private float averageGrade;
    
    public Student(String name, String surname, float averageGrade) {
        this.name = name;
        this.surname = surname;
        this.averageGrade = averageGrade;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the averageGrade
     */
    public float getAverageGrade() {
        return averageGrade;
    }

    /**
     * @param averageGrade the averageGrade to set
     */
    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }
}
