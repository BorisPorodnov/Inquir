package net.porodnov.inquirer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "quiz")
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_quiz")
    private String nameQuiz;

    @Column(name = "start_data")
    private LocalDateTime startData;

    @Column(name = "end_data")
    private LocalDateTime endData;

    @OneToMany(
        mappedBy = "quiz",
        cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<PollQuestion> pollQuestions;
}