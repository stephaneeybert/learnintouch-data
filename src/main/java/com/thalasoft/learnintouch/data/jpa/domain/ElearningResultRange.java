package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_result_range")
public class ElearningResultRange extends AbstractEntity {

    @Column(nullable = false)
    private int upperRange;
    private String grade;

    public ElearningResultRange() {
    }

    public int getUpperRange() {
        return this.upperRange;
    }

    public void setUpperRange(int upperRange) {
        this.upperRange = upperRange;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
