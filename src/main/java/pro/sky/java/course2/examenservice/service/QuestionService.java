package pro.sky.java.course2.examenservice.service;

import pro.sky.java.course2.examenservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSize();
}
