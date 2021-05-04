package net.porodnov.inquirer.dao;

import net.porodnov.inquirer.entity.QuizEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends CrudRepository<QuizEntity, Long> {

    QuizEntity findByName(String name);

    List<QuizEntity> findAll();
}
