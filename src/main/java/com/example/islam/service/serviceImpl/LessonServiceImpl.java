package com.example.islam.service.serviceImpl;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.Lesson;
import com.example.islam.entity.User;
import com.example.islam.repository.LessonRepository;
import com.example.islam.repository.UserRepository;
import com.example.islam.service.LessonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final UserRepository userRepository;
    public final LessonRepository lessonRepository;

    @Override
    public void saveLesson(Long userId, Lesson lesson) {
        lessonRepository.save(lesson);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(String.format("User by id %d not found", userId)));
        user.getLessons().add(lesson);
        lesson.setUser(user);
        userRepository.save(user);
        lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }


    @Override
    public Lesson findByIdLesson(Long lessonId) {
        try {
            return lessonRepository.findById(lessonId).orElseThrow(() -> new MyException("Lesson not found!"));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateLessonById(Long lessonId, Lesson lesson) throws MyException {
        Lesson oldLesson = lessonRepository.findById(lessonId).orElseThrow(() -> new MyException("not"));
        oldLesson.setLessonName(lesson.getLessonName());
        oldLesson.setStartLessonDate(lesson.getStartLessonDate());
        lessonRepository.save(oldLesson);

    }

    @Override
    public void deleteLessonById(Long lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public List<Lesson> LessonSearch(String word) {
        String searchWord = word + "%";
        return lessonRepository.searchLesson(searchWord);
    }


}
