package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_e_l_paragraph")
public class ElearningLessonParagraph extends AbstractEntity {

    @Column(nullable = false)
    private String headline;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String body;
    private String image;
    private String audio;
    @Column(length = 1024)
    private String video;
    private String videoUrl;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "elearning_lesson_heading_id")
    private ElearningLessonHeading elearningLessonHeading;
    @ManyToOne
    @JoinColumn(name = "elearning_lesson_id", nullable = false)
    private ElearningLesson elearningLesson;
    @ManyToOne
    @JoinColumn(name = "elearning_exercise_id")
    private ElearningExercise elearningExercise;
    private String exerciseTitle;

    public ElearningLessonParagraph() {
    }

    public ElearningLessonHeading getElearningLessonHeading() {
        return this.elearningLessonHeading;
    }

    public void setElearningLessonHeading(ElearningLessonHeading elearningLessonHeading) {
        this.elearningLessonHeading = elearningLessonHeading;
    }

    public ElearningExercise getElearningExercise() {
        return this.elearningExercise;
    }

    public void setElearningExercise(ElearningExercise elearningExercise) {
        this.elearningExercise = elearningExercise;
    }

    public ElearningLesson getElearningLesson() {
        return this.elearningLesson;
    }

    public void setElearningLesson(ElearningLesson elearningLesson) {
        this.elearningLesson = elearningLesson;
    }

    public String getHeadline() {
        return this.headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public String getExerciseTitle() {
        return this.exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

}
