package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_course_info")
public class ElearningCourseInfo extends AbstractEntity {

    private String headline;
    @Lob
    @Column(columnDefinition = "TEXT", nullable = false, length = 65535)
    private String information;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "elearning_course_id", nullable = false)
    private ElearningCourse elearningCourse;

    public ElearningCourseInfo() {
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getListOrder() {
        return listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public ElearningCourse getElearningCourse() {
        return elearningCourse;
    }

    public void setElearningCourse(ElearningCourse elearningCourse) {
        this.elearningCourse = elearningCourse;
    }

}
