package dev.wolneicordeiro.springbootneo4j.repositories;

import dev.wolneicordeiro.springbootneo4j.models.Lesson;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface LessonRepository extends Neo4jRepository<Lesson, Long> {
    @Query("MATCH (:Course {identifier: $identifier})<-[r:BELONGS_TO]-(lessons:Lesson) RETURN lessons")
    List<Lesson> findLessonByIdentifier(String identifier);
}
