package pro.sky.java.course2.examenservice.constants;

import pro.sky.java.course2.examenservice.domain.Question;

import java.util.*;

public class ExaminerServiceApplicationConstants {

    public final static int ZERO = 0;
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static String CORRECT_STRING_QUESTION = "CORRECT_STRING_QUESTION?";
    public final static String CORRECT_STRING_ANSWER = "CORRECT_STRING_ANSWER.";
    public final static Question CORRECT_QUESTION = new Question(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER);
    public final static String SECOND_CORRECT_STRING_QUESTION = "SECOND_CORRECT_STRING_QUESTION?";
    public final static String SECOND_CORRECT_STRING_ANSWER = "SECOND_CORRECT_STRING_ANSWER.";
    public final static Question SECOND_CORRECT_QUESTION = new Question(SECOND_CORRECT_STRING_QUESTION, SECOND_CORRECT_STRING_ANSWER);
    public final static AbstractMap<String,Question> CORRECT_QUESTION_MAP = new HashMap<>(Map.of(
            CORRECT_STRING_QUESTION,
            CORRECT_QUESTION,
            SECOND_CORRECT_STRING_QUESTION,
            SECOND_CORRECT_QUESTION));
    public final static Collection<Question> CORRECT_QUESTION_COLLECTION = Map.copyOf(CORRECT_QUESTION_MAP).values();

}
