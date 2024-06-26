package dev.wolneicordeiro.springbootneo4j.repositories;

import dev.wolneicordeiro.springbootneo4j.models.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends Neo4jRepository<Course, Long> {
    Optional<Course> findCourseByIdentifier(String identifier);
    @Query("MATCH (:User {username: $username})-[:ENROLLED_IN]->(course:Course) RETURN courses")
    List<Course> getAllEnrolledCourseByUsername(String username);
}
