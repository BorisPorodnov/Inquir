package net.porodnov.inquirer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "poll_question_entity")
@Getter
@Setter
@RequiredArgsConstructor
public class PollQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String textQuestion;
    private int displayOrder; //  Порядок отображения

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private QuizEntity quiz;

}