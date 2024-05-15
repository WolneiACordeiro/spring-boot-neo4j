package dev.wolneicordeiro.springbootneo4j.controllers;

import dev.wolneicordeiro.springbootneo4j.models.Course;
import dev.wolneicordeiro.springbootneo4j.objects.CourseDTO;
import dev.wolneicordeiro.springbootneo4j.services.CourseEnrolmentService;
import dev.wolneicordeiro.springbootneo4j.services.CourseService;
import dev.wolneicordeiro.springbootneo4j.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final LessonService lessonService;
    private final CourseEnrolmentService courseEnrolmentService;

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> courseIndex(Principal principal) {
        List<Course> courses = courseService.getAllCourses();

        List<CourseDTO> responseCourses = courses.stream().map(
                (course) -> {
                    CourseDTO responseCourse = new CourseDTO();

                    responseCourse.setIdentifier(course.getIdentifier());
                    responseCourse.setTitle(course.getTitle());
                    responseCourse.setTeacher(course.getTeacher());
                    responseCourse.setLessons(lessonService.getAllLessonsByCourseIdentifier(course.getIdentifier()));

                    if (principal != null)
                        responseCourse.setEnrolled(courseEnrolmentService.getEnrolmentStatus(principal.getName(),
                                course.getIdentifier()));

                    return responseCourse;
                }
        ).collect(Collectors.toList());

        return new ResponseEntity<>(responseCourses, HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<CourseDTO> courseDetails(@PathVariable String identifier, Principal principal) {
        Course course = courseService.getCourseByIdentifier(identifier);
        CourseDTO responseCourse = new CourseDTO();

        responseCourse.setIdentifier(course.getIdentifier());
        responseCourse.setTitle(course.getTitle());
        responseCourse.setTeacher(course.getTeacher());
        responseCourse.setLessons(lessonService.getAllLessonsByCourseIdentifier(identifier));

        if (principal != null)
            responseCourse.setEnrolled(courseEnrolmentService.getEnrolmentStatus(principal.getName(), identifier));

        return new ResponseEntity<>(responseCourse, HttpStatus.OK);
    }
}
