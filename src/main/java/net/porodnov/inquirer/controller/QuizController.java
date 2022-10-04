package net.porodnov.inquirer.controller;

import net.porodnov.inquirer.Exception.QuizAlreadyExistExseption;
import net.porodnov.inquirer.Exception.QuizNotFoundException;
import net.porodnov.inquirer.dao.QuizDao;
import net.porodnov.inquirer.entity.QuizEntity;
import net.porodnov.inquirer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private final QuizService quizService;

    public QuizController(QuizService quizService, QuizDao quizDao) {
        this.quizService = quizService;
    }


    @PutMapping("{id}")
    public ResponseEntity updateQuiz(@PathVariable Long id, @RequestBody QuizEntity entity) {
        return ResponseEntity.ok(quizService.updateQuizBy(id, entity));
    }


    @PostMapping("/{id}")
    public ResponseEntity getQuizBy(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getBy(id));
    }

    @DeleteMapping("{id}")

    public ResponseEntity deleteBy(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(quizService.deleteBy(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @PostMapping
    public ResponseEntity create(@RequestBody QuizEntity quizEntity) {
        try {
            quizService.save(quizEntity);
            return ResponseEntity.ok("Опрос был успешно создан в БазеДанных");
        } catch (QuizAlreadyExistExseption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getQuiz() {
        try {
            return ResponseEntity.ok(quizService.getAllQuiz());
        } catch (QuizNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ишибка");
        }
    }

}