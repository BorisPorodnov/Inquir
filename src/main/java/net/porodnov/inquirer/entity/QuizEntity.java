package net.porodnov.inquirer.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quiz_entity")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime start = LocalDateTime.now();
    private LocalDateTime endd = LocalDateTime.now();
    private boolean activity;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    // @JsonManagedReference
    private List<PollQuestionEntity> pollQuestions;

    public QuizEntity() {
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime startData) {
        this.start = startData;
    }

    public LocalDateTime getEndd() {
        return endd;
    }

    public void setEndd(LocalDateTime endData) {
        this.endd = endData;
    }
}
