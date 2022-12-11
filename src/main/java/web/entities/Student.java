package web.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Student")
@Table(name = "Student")
public class Student implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="myseq")
    @SequenceGenerator( name="myseq", sequenceName="SEQUENCE_NAME", allocationSize=1)
    private Integer id;
    private String name;
    private String surName;
    private Integer matriculation;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Student_Courses",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    Set<Course> courses = new HashSet<>();
    public Student(String name, String surName, Integer matriculation) {
        this.name = name;
        this.surName = surName;
        this.matriculation = matriculation;
    }

    public Student() {

    }

    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(Integer matriculation) {
        this.matriculation = matriculation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
