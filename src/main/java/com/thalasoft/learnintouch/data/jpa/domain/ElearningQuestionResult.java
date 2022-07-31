package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_e_q_result")
public class ElearningQuestionResult extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "elearning_question_id", nullable = false)
    private ElearningQuestion elearningQuestion;
    @ManyToOne
    @JoinColumn(name = "elearning_result_id", nullable = false)
    private ElearningResult elearningResult;
    @ManyToOne
    @JoinColumn(name = "elearning_answer_id")
    private ElearningAnswer elearningAnswer;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String elearningAnswerText;
    private int elearningAnswerOrder;

    public ElearningQuestionResult() {
    }

    public ElearningQuestion getElearningQuestion() {
        return this.elearningQuestion;
    }

    public void setElearningQuestion(ElearningQuestion elearningQuestion) {
        this.elearningQuestion = elearningQuestion;
    }

    public ElearningResult getElearningResult() {
        return this.elearningResult;
    }

    public void setElearningResult(ElearningResult elearningResult) {
        this.elearningResult = elearningResult;
    }

    public ElearningAnswer getElearningAnswer() {
        return this.elearningAnswer;
    }

    public void setElearningAnswer(ElearningAnswer elearningAnswer) {
        this.elearningAnswer = elearningAnswer;
    }

    public String getElearningAnswerText() {
        return this.elearningAnswerText;
    }

    public void setElearningAnswerText(String elearningAnswerText) {
        this.elearningAnswerText = elearningAnswerText;
    }

    public int getElearningAnswerOrder() {
        return elearningAnswerOrder;
    }

    public void setElearningAnswerOrder(int elearningAnswerOrder) {
        this.elearningAnswerOrder = elearningAnswerOrder;
    }

}
