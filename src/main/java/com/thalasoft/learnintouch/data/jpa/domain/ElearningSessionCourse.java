package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_session_course")
public class ElearningSessionCourse extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "elearning_session_id", nullable = false)
    private ElearningSession elearningSession;
    @ManyToOne
    @JoinColumn(name = "elearning_course_id", nullable = false)
    private ElearningCourse elearningCourse;

    public ElearningSessionCourse() {
    }

    public ElearningSession getElearningSession() {
        return this.elearningSession;
    }

    public void setElearningSession(ElearningSession elearningSession) {
        this.elearningSession = elearningSession;
    }

    public ElearningCourse getElearningCourse() {
        return this.elearningCourse;
    }

    public void setElearningCourse(ElearningCourse elearningCourse) {
        this.elearningCourse = elearningCourse;
    }

}
