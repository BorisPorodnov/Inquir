package net.porodnov.inquirer.rest;

import net.porodnov.inquirer.model.Quiz;
import net.porodnov.inquirer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Quiz> getAll() {
        return quizService.getALL();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Quiz saveQuiz(@RequestBody @Valid Quiz quiz) {
        return this.quizService.save(quiz);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable("id") Quiz id) {
        quizService.delete(id);
    }

   @PutMapping("/updated")
   public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz, @PathVariable Long id){
       return Optional op = new Op
   }


}
