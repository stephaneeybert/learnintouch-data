package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_assignment")
public class ElearningAssignment extends AbstractEntity {

    @Column(nullable = false)
    private boolean onlyOnce;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime openingDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime closingDate;
    @ManyToOne
    @JoinColumn(name = "elearning_subscription_id", nullable = false)
    private ElearningSubscription elearningSubscription;
    @ManyToOne
    @JoinColumn(name = "elearning_exercise_id", nullable = false)
    private ElearningExercise elearningExercise;
    @ManyToOne
    @JoinColumn(name = "elearning_result_id")
    private ElearningResult elearningResult;

    public ElearningAssignment() {
    }

    public ElearningSubscription getElearningSubscription() {
        return elearningSubscription;
    }

    public void setElearningSubscription(ElearningSubscription elearningSubscription) {
        this.elearningSubscription = elearningSubscription;
    }

    public ElearningExercise getElearningExercise() {
        return elearningExercise;
    }

    public void setElearningExercise(ElearningExercise elearningExercise) {
        this.elearningExercise = elearningExercise;
    }

    public ElearningResult getElearningResult() {
        return elearningResult;
    }

    public void setElearningResult(ElearningResult elearningResult) {
        this.elearningResult = elearningResult;
    }

    public boolean isOnlyOnce() {
        return onlyOnce;
    }

    public void setOnlyOnce(boolean onlyOnce) {
        this.onlyOnce = onlyOnce;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

}
