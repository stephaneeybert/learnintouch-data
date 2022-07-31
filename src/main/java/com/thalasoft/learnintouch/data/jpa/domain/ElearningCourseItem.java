package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_course_item")
public class ElearningCourseItem extends AbstractEntity {

    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "elearning_lesson_id")
    private ElearningLesson elearningLesson;
    @ManyToOne
    @JoinColumn(name = "elearning_exercise_id")
    private ElearningExercise elearningExercise;
    @ManyToOne
    @JoinColumn(name = "elearning_course_id", nullable = false)
    private ElearningCourse elearningCourse;

    public ElearningCourseItem() {
    }

    public ElearningExercise getElearningExercise() {
        return this.elearningExercise;
    }

    public void setElearningExercise(ElearningExercise elearningExercise) {
        this.elearningExercise = elearningExercise;
    }

    public ElearningCourse getElearningCourse() {
        return this.elearningCourse;
    }

    public void setElearningCourse(ElearningCourse elearningCourse) {
        this.elearningCourse = elearningCourse;
    }

    public ElearningLesson getElearningLesson() {
        return this.elearningLesson;
    }

    public void setElearningLesson(ElearningLesson elearningLesson) {
        this.elearningLesson = elearningLesson;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
