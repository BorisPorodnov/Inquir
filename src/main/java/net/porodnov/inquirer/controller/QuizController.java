package net.porodnov.inquirer.controller;

import lombok.RequiredArgsConstructor;
import net.porodnov.inquirer.model.Filter;
import net.porodnov.inquirer.model.Quiz;
import net.porodnov.inquirer.service.QuizServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizServiceImpl quizService;

    @GetMapping("/all")
    public List<Quiz> getAll() {
        return quizService.getALL();
    }


    @PostMapping
    public Quiz saveQuiz(@RequestBody Quiz quiz) {
        return this.quizService.save(quiz);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        quizService.delete(id);
    }

    @PutMapping("{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    @PostMapping("/search")
    public List<Quiz> getBy(@RequestBody Filter filter) {
        return quizService.get(filter);
    }

}