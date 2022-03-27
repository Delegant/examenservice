package pro.sky.java.course2.examenservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examenservice.domain.Question;
import pro.sky.java.course2.examenservice.service.QuestionService;

import java.util.Collection;

@RestController
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                    @RequestParam("answer") String answer){
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question){
        return questionService.remove(question);
    }

    @GetMapping("/")
    public Collection<Question> getAll(){
        return questionService.getAll();
    }

}
