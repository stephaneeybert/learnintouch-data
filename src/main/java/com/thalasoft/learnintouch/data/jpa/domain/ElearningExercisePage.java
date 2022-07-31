package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_exercise_page")
public class ElearningExercisePage extends AbstractEntity {

    private String name;
    private String description;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String instructions;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String text;
    private String image;
    private String audio;
    @Column(length = 1024)
    private String video;
    private String videoUrl;
    @Column(length = 50)
    private String questionType;
    @Column(length = 50)
    private String hintPlacement;
    @Column(nullable = false)
    private boolean hideText;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "elearning_exercise_id", nullable = false)
    private ElearningExercise elearningExercise;

    public ElearningExercisePage() {
    }

    public ElearningExercise getElearningExercise() {
        return this.elearningExercise;
    }

    public void setElearningExercise(ElearningExercise elearningExercise) {
        this.elearningExercise = elearningExercise;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getHideText() {
        return this.hideText;
    }

    public void setHideText(boolean hideText) {
        this.hideText = hideText;
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

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getHintPlacement() {
        return this.hintPlacement;
    }

    public void setHintPlacement(String hintPlacement) {
        this.hintPlacement = hintPlacement;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
