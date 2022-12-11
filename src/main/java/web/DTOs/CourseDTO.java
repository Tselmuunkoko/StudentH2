package web.DTOs;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private String name;
    private Integer vote;

    public CourseDTO(String name, Integer vote) {
        this.name = name;
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public Integer getVote() {
        return vote;
    }
}
