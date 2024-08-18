package com.example.islam.service;


import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Long userId, Lesson lesson);

    List<Lesson> findAllLessons();

    Lesson findByIdLesson(Long lessonId);

    void updateLessonById(Long lessonId, Lesson lesson) throws MyException;

    void deleteLessonById(Long lessonId);

    List<Lesson> LessonSearch(String word);

}
