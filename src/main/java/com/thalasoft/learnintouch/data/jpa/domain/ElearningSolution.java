package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_solution")
public class ElearningSolution extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "elearning_question_id", nullable = false)
    private ElearningQuestion elearningQuestion;
    @ManyToOne
    @JoinColumn(name = "elearning_answer_id", nullable = false)
    private ElearningAnswer elearningAnswer;

    public ElearningSolution() {
    }

    public ElearningQuestion getElearningQuestion() {
        return this.elearningQuestion;
    }

    public void setElearningQuestion(ElearningQuestion elearningQuestion) {
        this.elearningQuestion = elearningQuestion;
    }

    public ElearningAnswer getElearningAnswer() {
        return this.elearningAnswer;
    }

    public void setElearningAnswer(ElearningAnswer elearningAnswer) {
        this.elearningAnswer = elearningAnswer;
    }

}
