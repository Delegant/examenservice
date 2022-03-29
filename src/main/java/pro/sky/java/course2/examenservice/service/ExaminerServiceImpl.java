package pro.sky.java.course2.examenservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examenservice.domain.Question;
import pro.sky.java.course2.examenservice.exceptions.BadRequestException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getSize()) {
            throw new BadRequestException("incorrect amount");
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
