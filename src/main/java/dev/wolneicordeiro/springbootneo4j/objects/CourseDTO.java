package dev.wolneicordeiro.springbootneo4j.objects;

import dev.wolneicordeiro.springbootneo4j.models.Lesson;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CourseDTO {
    private String identifier;
    private String title;
    private String teacher;
    @Setter
    private List<Lesson> Lessons = new ArrayList<>();

    public CourseDTO(String identifier, String title, String teacher) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
    }

}
