package net.porodnov.inquirer.dao;

import net.porodnov.inquirer.entity.PollQuestionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PollQuestionDao extends CrudRepository<PollQuestionEntity, Long> {

    List<PollQuestionEntity> findAll();
}
