package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_heading")
public class NewsHeading extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    private String description;
    @Column(length = 255)
    private String image;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "news_publication_id", nullable = false)
    private NewsPublication newsPublication;

    public NewsHeading() {
    }

    public NewsPublication getNewsPublication() {
        return this.newsPublication;
    }

    public void setNewsPublication(NewsPublication newsPublication) {
        this.newsPublication = newsPublication;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
