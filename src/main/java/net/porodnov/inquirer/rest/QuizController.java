package net.porodnov.inquirer.rest;

import net.porodnov.inquirer.model.Quiz;
import net.porodnov.inquirer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping(value = "")
    public List<Quiz> getAll() {
        return quizService.getALL();
    }

    @PostMapping(value = "/adding")
    public Quiz saveQuiz(@RequestBody Quiz quiz) {
        return this.quizService.save(quiz);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable("id") Long id) {
        quizService.delete(id);
    }

    @PutMapping(value = "{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

}
