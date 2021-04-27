package net.porodnov.inquirer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "poll_question")
public class PollQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text_question")
    private String textQuestion;

    @Column(name = "display_order")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonBackReference
    private Quiz quiz;

    private boolean activity;

}