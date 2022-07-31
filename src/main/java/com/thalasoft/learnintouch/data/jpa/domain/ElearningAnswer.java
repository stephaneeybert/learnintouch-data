package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_answer")
public class ElearningAnswer extends AbstractEntity {

    private String answer;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String explanation;
    private String image;
    private String audio;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "elearning_question_id", nullable = false)
    private ElearningQuestion elearningQuestion;

    public ElearningAnswer() {
    }

    public ElearningQuestion getElearningQuestion() {
        return this.elearningQuestion;
    }

    public void setElearningQuestion(ElearningQuestion elearningQuestion) {
        this.elearningQuestion = elearningQuestion;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudio() {
        return this.audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
