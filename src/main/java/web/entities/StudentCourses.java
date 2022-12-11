package web.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="StudentCourses")
@Table(name = "STUDENT_COURSES")
public class StudentCourses implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="myseq")
    @SequenceGenerator( name="myseq", sequenceName="SEQUENCE_NAME", allocationSize=1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("STUDENT_ID")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("COURSE_ID")
    private Course course;

    @Column(name = "VOTE")
    private Integer vote;

    private StudentCourses() {}

    public Integer getVote() {
        return vote;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }
}
