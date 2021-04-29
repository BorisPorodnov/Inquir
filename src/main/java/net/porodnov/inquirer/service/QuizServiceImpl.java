package net.porodnov.inquirer.service;

import lombok.RequiredArgsConstructor;
import net.porodnov.inquirer.dao.QuizDao;
import net.porodnov.inquirer.model.Filter;
import net.porodnov.inquirer.model.Quiz;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizDao dao;

    @Override
    public Quiz getOne(Long id) {
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

    public List<Quiz> get(Filter filter) {

        List<Quiz> quizList = dao.findAll();

        List<Quiz> quizzes = new ArrayList<>();

        quizList.forEach(it -> {
            if (it.getNameQuiz().equals(filter.getNameQuiz()))
                quizzes.add(it);
        });
        return quizzes;
    }
}