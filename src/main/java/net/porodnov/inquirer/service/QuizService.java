package net.porodnov.inquirer.service;

import net.porodnov.inquirer.dao.Dao;
import net.porodnov.inquirer.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService implements ServiceImpl {

    @Autowired
    private Dao dao;

    @Override
    public Quiz getById(Long id) {
        return null;
    }

    @Override
    public Quiz save(Quiz quiz) {
        dao.save(quiz);
        return quiz;
    }

    @Override
    public void delete(Quiz id) {
        dao.delete(id);
    }

    @Override
    public List<Quiz> getALL() {
        return dao.findAll();
    }
}
