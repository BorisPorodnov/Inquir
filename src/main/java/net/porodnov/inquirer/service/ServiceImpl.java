package net.porodnov.inquirer.service;

import net.porodnov.inquirer.model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceImpl {

    Quiz save(Quiz quiz);

    Quiz updateQuiz(Long id, Quiz quiz);

    void delete(Quiz id);

    List<Quiz> getALL();

}