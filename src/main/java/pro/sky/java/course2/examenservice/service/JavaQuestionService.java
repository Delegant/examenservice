package pro.sky.java.course2.examenservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examenservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Map<String, Question> questionMap = new HashMap<>();

    @Override
    public Question add(String question, String answer) {
        Question addedQuestion = new Question(question, answer);
        questionMap.putIfAbsent(question, addedQuestion);
        return questionMap.get(question);
    }

    @Override
    public Question add(Question question) {
        return this.add(question.getQuestion(), question.getAnswer());
    }

    @Override
    public Question remove(String question) {
        if (!questionMap.containsKey(question)) {
            throw new IllegalArgumentException();
        }
        return questionMap.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Map.copyOf(questionMap).values();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionsArrayList = new ArrayList<>(this.getAll());
        return questionsArrayList.get(random.nextInt(questionsArrayList.size()));
    }

    @Override
    public int getSize() {
        return questionMap.size();
    }
}
