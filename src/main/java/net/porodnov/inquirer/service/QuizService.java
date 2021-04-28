package net.porodnov.inquirer.service;

import net.porodnov.inquirer.dao.Dao;
import net.porodnov.inquirer.model.Quiz;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService implements ServiceImpl {

    @Autowired
    private Dao dao;

    @Override
    public Quiz getById(Long id) {
        return dao.getOne(id);
    }

    @Override
    public Quiz save(Quiz quiz) {
        return dao.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Long id, Quiz quiz) {
        return dao.findById(id).map(it -> {
            it.setNameQuiz(quiz.getNameQuiz());
            it.setStartData(quiz.getStartData());
            it.setEndData(quiz.getEndData());
            it.setPollQuestions(quiz.getPollQuestions());
            return dao.save(it);
        }).orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found"));
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Quiz> getALL() {
        return dao.findAll();
    }

}
