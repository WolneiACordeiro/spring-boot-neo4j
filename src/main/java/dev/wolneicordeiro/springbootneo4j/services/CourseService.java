package dev.wolneicordeiro.springbootneo4j.services;

import dev.wolneicordeiro.springbootneo4j.models.Course;
import dev.wolneicordeiro.springbootneo4j.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseByIdentifier(String identifier) {
        return courseRepository.findCourseByIdentifier(identifier).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }

}
