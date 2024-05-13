package dev.wolneicordeiro.springbootneo4j.services;

import dev.wolneicordeiro.springbootneo4j.models.Lesson;
import dev.wolneicordeiro.springbootneo4j.repositories.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public List<Lesson> getAllLessonsByCourseIdentifier(String identifier){
        return lessonRepository.findLessonByIdentifier(identifier);
    }
}
