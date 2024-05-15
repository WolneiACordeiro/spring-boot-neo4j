package dev.wolneicordeiro.springbootneo4j.queryresults;

import dev.wolneicordeiro.springbootneo4j.models.Course;
import dev.wolneicordeiro.springbootneo4j.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseEnrolmentQueryResult {
    private User user;
    private Course course;
}
