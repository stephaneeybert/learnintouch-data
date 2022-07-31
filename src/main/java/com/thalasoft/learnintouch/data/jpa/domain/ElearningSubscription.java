package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_subscription")
public class ElearningSubscription extends AbstractEntity {

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime subscriptionDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime subscriptionClose;
    @ManyToOne
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private ElearningCourse elearningCourse;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private ElearningSession elearningSession;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private ElearningTeacher elearningTeacher;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ElearningClass elearningClass;
    @Column(nullable = false)
    private boolean watchLive;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime lastActive;
    @ManyToOne
    @JoinColumn(name = "last_exercise_id")
    private ElearningExercise lastExercise;
    @ManyToOne
    @JoinColumn(name = "last_exercise_page_id")
    private ElearningExercisePage lastExercisePage;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String whiteboard;

    public ElearningSubscription() {
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public ElearningCourse getElearningCourse() {
        return this.elearningCourse;
    }

    public void setElearningCourse(ElearningCourse elearningCourse) {
        this.elearningCourse = elearningCourse;
    }

    public ElearningSession getElearningSession() {
        return this.elearningSession;
    }

    public void setElearningSession(ElearningSession elearningSession) {
        this.elearningSession = elearningSession;
    }

    public ElearningTeacher getElearningTeacher() {
        return this.elearningTeacher;
    }

    public void setElearningTeacher(ElearningTeacher elearningTeacher) {
        this.elearningTeacher = elearningTeacher;
    }

    public ElearningClass getElearningClass() {
        return this.elearningClass;
    }

    public void setElearningClass(ElearningClass elearningClass) {
        this.elearningClass = elearningClass;
    }

    public LocalDateTime getSubscriptionDate() {
        return this.subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public LocalDateTime getSubscriptionClose() {
        return subscriptionClose;
    }

    public void setSubscriptionClose(LocalDateTime subscriptionClose) {
        this.subscriptionClose = subscriptionClose;
    }

    public boolean getWatchLive() {
        return watchLive;
    }

    public void setWatchLive(boolean watchLive) {
        this.watchLive = watchLive;
    }

    public ElearningExercise getLastExercise() {
        return lastExercise;
    }

    public void setLastExercise(ElearningExercise lastExercise) {
        this.lastExercise = lastExercise;
    }

    public ElearningExercisePage getLastExercisePage() {
        return lastExercisePage;
    }

    public void setLastExercisePage(ElearningExercisePage lastExercisePage) {
        this.lastExercisePage = lastExercisePage;
    }

    public LocalDateTime getLastActive() {
        return lastActive;
    }

    public void setLastActive(LocalDateTime lastActive) {
        this.lastActive = lastActive;
    }

    public String getWhiteboard() {
        return whiteboard;
    }

    public void setWhiteboard(String whiteboard) {
        this.whiteboard = whiteboard;
    }

}
