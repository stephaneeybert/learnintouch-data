package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_content_import_history")
public class ContentImportHistory extends AbstractEntity {

    @Column(nullable = false)
    private String domainName;
    private String course;
    private String lesson;
    private String exercise;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime importDatetime;

    public ContentImportHistory() {
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLesson() {
        return this.lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getExercise() {
        return this.exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public LocalDateTime getImportDatetime() {
        return this.importDatetime;
    }

    public void setImportDatetime(LocalDateTime importDatetime) {
        this.importDatetime = importDatetime;
    }

}
