package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_lesson_heading")
public class ElearningLessonHeading extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String content;
    @Column(length = 255)
    private String image;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "elearning_lesson_model_id")
    private ElearningLessonModel elearningLessonModel;

    public ElearningLessonHeading() {
    }

    public ElearningLessonModel getElearningLessonModel() {
        return this.elearningLessonModel;
    }

    public void setElearningLessonModel(ElearningLessonModel elearningLessonModel) {
        this.elearningLessonModel = elearningLessonModel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
