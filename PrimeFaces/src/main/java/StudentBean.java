/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "studentBean")
@RequestScoped
public class StudentBean {

    private List<Student> students;
    
    public StudentBean() {
    }
    
    @PostConstruct
    private void init() {
        students = new ArrayList();
        students.add(new Student("Aaa", "Aaa", (float) 4.52));
        students.add(new Student("Bbb", "Bbb", (float) 4.26));
        students.add(new Student("Ccc", "Ccc", (float) 4.73));
        students.add(new Student("Ddd", "Ddd", (float) 3.94));
        students.add(new Student("Eee", "Eee", (float) 4.48));
    }

    public List<Student> getStudents() {
        return students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
