package pro.sky.java.course2.examenservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examenservice.domain.Question;
import pro.sky.java.course2.examenservice.exceptions.BadRequestException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.examenservice.constants.ExaminerServiceApplicationConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    private ExaminerService out;

    @BeforeEach
    private void initOut(){
        out = new ExaminerServiceImpl(javaQuestionServiceMock);
    }


    @Test
    void shouldReturnCollectionRandomQuestionsWhenAddTwoQuestionsAndGetNumberOfQuestionOne() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(CORRECT_QUESTION, SECOND_CORRECT_QUESTION);
        when(javaQuestionServiceMock.getSize()).thenReturn(TWO);
        Collection<Question> expected = List.of(CORRECT_QUESTION);
        Collection<Question> anotherExpected = List.of(SECOND_CORRECT_QUESTION);
        Collection<Question> actual = out.getQuestions(ONE);
        assertTrue (actual.containsAll(expected) || actual.containsAll(anotherExpected));
        verify(javaQuestionServiceMock, times(1)).getRandomQuestion();
        //вопрос, почему only() вместо times (1), вызывает ошибку?
    }

    @Test
    void shouldReturnCollectionRandomQuestionsWhenAddTwoQuestionsAndGetNumberOfQuestionsTwo() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(CORRECT_QUESTION, SECOND_CORRECT_QUESTION);
        when(javaQuestionServiceMock.getSize()).thenReturn(TWO);
        Collection<Question> expected = List.of(CORRECT_QUESTION, SECOND_CORRECT_QUESTION);
        Collection<Question> actual = out.getQuestions(TWO);
        assertTrue (actual.containsAll(expected) && expected.containsAll(actual));
        verify(javaQuestionServiceMock, atLeast(TWO)).getRandomQuestion();
    }

    @Test
    void shouldTrowBadRequestExceptionWhenAddOneQuestionsAndGetNumberOfQuestionsTwo() {
        when(javaQuestionServiceMock.getSize()).thenReturn(ONE);
        assertThrows(BadRequestException.class, () -> out.getQuestions(TWO));
    }
}
