package net.porodnov.inquirer.service;

import net.porodnov.inquirer.Exception.QuizAlreadyExistExseption;
import net.porodnov.inquirer.Exception.QuizNotFoundException;
import net.porodnov.inquirer.dao.QuizDao;
import net.porodnov.inquirer.entity.QuizEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuizDao quizDao;

    public QuizService(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    public void save(QuizEntity quizEntity) throws QuizAlreadyExistExseption {
        if (quizDao.findByName(quizEntity.getName()) != null)
            throw new QuizAlreadyExistExseption("Такой Опрос уже существует");
        quizDao.save(quizEntity);
    }

    public List<QuizEntity> getAllQuiz() throws QuizNotFoundException {
        List<QuizEntity> entityList = quizDao.findAll();
        if (entityList.isEmpty()) {
            throw new QuizNotFoundException("Опросов не существует");
        }
        return entityList;
    }

    public Long deleteBy(Long id) {
        Long result = quizDao.findById(id).get().getId();
        quizDao.deleteById(result);
        return result;
    }

    public QuizEntity getBy(Long id) {
        List<QuizEntity> list = quizDao.findAll();
        List<QuizEntity> responseList = new ArrayList<>();
        QuizEntity resp = new QuizEntity();
        for (QuizEntity e : list) {
            if (e.getId().toString().equals(id.toString())) {
                resp.setId(e.getId());
                resp.setStart(e.getStart());
                resp.setEndd(e.getEndd());
                resp.setName(e.getName());
                resp.setActivity(e.isActivity());
                responseList.add(e);
            }
        }
        return responseList.get(0);
    }

    public QuizEntity updateQuizBy(Long id, QuizEntity quiz) {
        QuizEntity entity = quizDao.findById(id).get();
        entity.setName(quiz.getName());
        quizDao.save(entity);
        return entity;
    }
}