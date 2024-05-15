package dev.wolneicordeiro.springbootneo4j.services;

import dev.wolneicordeiro.springbootneo4j.models.Course;
import dev.wolneicordeiro.springbootneo4j.queryresults.CourseEnrolmentQueryResult;
import dev.wolneicordeiro.springbootneo4j.repositories.CourseRepository;
import dev.wolneicordeiro.springbootneo4j.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseEnrolmentService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public Boolean getEnrolmentStatus(String username, String identifier){
        return userRepository.findEnrolmentStatus(username, identifier);
    }

    public CourseEnrolmentQueryResult enrollIn(String username, String identifier){
        return userRepository.createEnrolmentRelationship(username, identifier);
    }

    public List<Course> getAllEnrolledCoursesByUsername(String username){
        return courseRepository.getAllEnrolledCourseByUsername(username);
    }
}
