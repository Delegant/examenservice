package pro.sky.java.course2.examenservice.service;

import pro.sky.java.course2.examenservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int count);
}
