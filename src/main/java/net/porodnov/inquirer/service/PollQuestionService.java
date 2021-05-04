package net.porodnov.inquirer.service;

import net.porodnov.inquirer.dao.PollQuestionDao;
import net.porodnov.inquirer.dao.QuizDao;
import net.porodnov.inquirer.entity.PollQuestionEntity;
import net.porodnov.inquirer.entity.QuizEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollQuestionService {
    private final PollQuestionDao pollQuestionDao;
    private final QuizDao quizDao;

    public PollQuestionService(PollQuestionDao pollQuestionDao, QuizDao quizDao) {
        this.pollQuestionDao = pollQuestionDao;
        this.quizDao = quizDao;
    }

    public PollQuestionEntity createQuestion(PollQuestionEntity entity, Long id) {
        QuizEntity quizEntity = quizDao.findById(id).get();
        entity.setQuiz(quizEntity);
        return pollQuestionDao.save(entity);
    }

    public List<PollQuestionEntity> getAllQuestion() {
        return pollQuestionDao.findAll();
    }

}
