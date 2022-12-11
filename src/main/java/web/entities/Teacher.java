package web.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Teacher")
@Table(name = "Teacher")
public class Teacher implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="myseq")
    @SequenceGenerator( name="myseq", sequenceName="SEQUENCE_NAME", allocationSize=1)
    private Integer id;
    private String name;
    private String surName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    public Teacher(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Teacher() {

    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
