package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_question")
public class ElearningQuestion extends AbstractEntity {

    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String question;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String explanation;
    private String image;
    private String audio;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String hint;
    private int points;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "elearning_exercise_page_id", nullable = false)
    private ElearningExercisePage elearningExercisePage;

    public ElearningQuestion() {
    }

    public ElearningExercisePage getElearningExercisePage() {
        return this.elearningExercisePage;
    }

    public void setElearningExercisePage(ElearningExercisePage elearningExercisePage) {
        this.elearningExercisePage = elearningExercisePage;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public String getHint() {
        return this.hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
