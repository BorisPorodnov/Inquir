package net.porodnov.inquirer.controller;

import net.porodnov.inquirer.entity.PollQuestionEntity;
import net.porodnov.inquirer.service.PollQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/questions")
public class PollQuestionController {

    private final PollQuestionService pollQuestionService;

    public PollQuestionController(PollQuestionService pollQuestionService) {
        this.pollQuestionService = pollQuestionService;
    }

    @GetMapping
    public List<PollQuestionEntity> getAll() {
        return pollQuestionService.getAllQuestion();
    }

    @PostMapping("/{id}")
    public ResponseEntity createQuestion(@RequestBody PollQuestionEntity questionEntity,
                                         @PathVariable Long id) {
        try {
            return ResponseEntity.ok(pollQuestionService.createQuestion(questionEntity, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

  /*  @PutMapping
    public ResponseEntity activity(@RequestBody Long idQuestion) {
        try {

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
   */
}
