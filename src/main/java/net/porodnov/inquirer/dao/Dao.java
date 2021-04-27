package net.porodnov.inquirer.dao;

import net.porodnov.inquirer.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dao extends JpaRepository<Quiz, Long> {
}
