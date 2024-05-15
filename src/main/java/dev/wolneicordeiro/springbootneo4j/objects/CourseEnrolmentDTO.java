package dev.wolneicordeiro.springbootneo4j.objects;

import dev.wolneicordeiro.springbootneo4j.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEnrolmentDTO {
    private String username;
    private String name;
    private Course course;
}
