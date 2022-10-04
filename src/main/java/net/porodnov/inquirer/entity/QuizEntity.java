package net.porodnov.inquirer.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quiz_entity")
@Getter
@Setter
@RequiredArgsConstructor
public class QuizEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "start")
    private LocalDateTime start = LocalDateTime.now();
    @Column(name = "endd")
    private LocalDateTime endd = LocalDateTime.now();
    @Column(name = "activity")
    private boolean activity;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    // @JsonManagedReference
    private List<PollQuestionEntity> pollQuestions;

}
