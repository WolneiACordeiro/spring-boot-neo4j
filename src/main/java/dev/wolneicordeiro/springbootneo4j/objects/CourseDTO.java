package dev.wolneicordeiro.springbootneo4j.objects;

import dev.wolneicordeiro.springbootneo4j.models.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO {
    private String identifier;
    private String title;
    private String teacher;
    private List<Lesson> Lessons = new ArrayList<>();
    private Boolean enrolled;

    public CourseDTO(String identifier, String title, String teacher) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
    }

}
