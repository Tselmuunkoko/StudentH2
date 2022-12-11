package web.DTOs;

import java.io.Serializable;

public class CourseTeacherDTO implements Serializable {
    private String name;
    private String teacherName;
    private String teacherSurName;

    public CourseTeacherDTO(String name, String teacherName, String teacherSurName) {
        this.name = name;
        this.teacherName = teacherName;
        this.teacherSurName = teacherSurName;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherSurName() {
        return teacherSurName;
    }
}