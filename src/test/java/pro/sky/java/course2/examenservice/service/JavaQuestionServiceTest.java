package pro.sky.java.course2.examenservice.service;

import static pro.sky.java.course2.examenservice.constants.ExaminerServiceApplicationConstants.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examenservice.domain.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService out;

    @BeforeEach
    private void initialize(){
        out = new JavaQuestionService();
    }

    @Test
    void shouldReturnQuestionWhenAddCorrectStringQuestionAndAnswer() {
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertTrue(out.getAll().contains(CORRECT_QUESTION));
    }

    @Test
    void shouldReturnQuestionWhenAddCorrectQuestion() {
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_QUESTION));
        assertTrue(out.getAll().contains(CORRECT_QUESTION));
    }


    @Test
    void shouldReturnCollectionWithoutRemovedQuestion() {
        out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER);
        assertEquals(CORRECT_QUESTION, out.remove(CORRECT_STRING_QUESTION));
        assertFalse(out.getAll().contains(CORRECT_QUESTION));
    }

    @Test
    void shouldReturnCollectionWithAddedQuestion() {
        out.add(CORRECT_QUESTION);
        out.add(SECOND_CORRECT_QUESTION);
        Collection<Question> expected = List.of(CORRECT_QUESTION, SECOND_CORRECT_QUESTION);
        assertTrue(out.getAll().containsAll(expected) && expected.containsAll(out.getAll()));
    }

    @Test
    void shouldReturnRandomQuestion() {
        out.add(CORRECT_QUESTION);
        out.add(SECOND_CORRECT_QUESTION);
        Collection<Question> expected = List.of(CORRECT_QUESTION, SECOND_CORRECT_QUESTION);
        assertTrue(expected.contains(out.getRandomQuestion()));
    }

    @Test
    void shouldReturnSizeWhenAddDifferentQuestions() {
        assertEquals(ZERO, out.getSize());
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertEquals(ONE, out.getSize());
        assertEquals(SECOND_CORRECT_QUESTION, out.add(SECOND_CORRECT_STRING_QUESTION, SECOND_CORRECT_STRING_ANSWER));
        assertEquals(TWO, out.getSize());
    }

    @Test
    void shouldReturnSizeOneWhenAddTwoEqualQuestion() {
        assertEquals(ZERO, out.getSize());
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertEquals(ONE, out.getSize());
    }

}