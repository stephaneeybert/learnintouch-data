package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_story_image")
public class NewsStoryImage extends AbstractEntity {

    @Column(length = 255)
    private String image;
    private String description;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "news_story_id", nullable = false)
    private NewsStory newsStory;

    public NewsStoryImage() {
    }

    public NewsStory getNewsStory() {
        return this.newsStory;
    }

    public void setNewsStory(NewsStory newsStory) {
        this.newsStory = newsStory;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
