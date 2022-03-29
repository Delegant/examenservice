package pro.sky.java.course2.examenservice.service;

import static pro.sky.java.course2.examenservice.constants.ExaminerServiceApplicationConstants.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    JavaQuestionService out = new JavaQuestionService();

    @Test
    void shouldReturnQuestionWhenAddCorrectStringQuestionAndAnswer() {
        assertEquals(ZERO, out.getSize());
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertEquals(ONE, out.getSize());
    }

    @Test
    void shouldReturnQuestionWhenAddCorrectQuestion() {
        assertEquals(ZERO, out.getSize());
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_QUESTION));
        assertEquals(ONE, out.getSize());
    }


    @Test
    void remove() {
        out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER);
        assertEquals(CORRECT_QUESTION, out.remove(CORRECT_STRING_QUESTION));
        assertEquals(ZERO, out.getSize());
    }

    @Test
    void getAll() {
        out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER);
        out.add(SECOND_CORRECT_STRING_QUESTION, SECOND_CORRECT_STRING_ANSWER);
        assertEquals(TWO, out.getSize());
        assertEquals(CORRECT_QUESTION_COLLECTION, out.getAll());
    }

    @Test
    void getRandomQuestion() {
    }

    @Test
    void getSize() {
    }
}