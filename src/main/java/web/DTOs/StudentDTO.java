package web.DTOs;

import web.entities.Student;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class StudentDTO implements Serializable {
    private String name;
    private String surName;

    public StudentDTO(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }
}
