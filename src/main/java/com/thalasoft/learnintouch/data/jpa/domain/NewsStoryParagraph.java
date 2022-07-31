package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_story_paragraph")
public class NewsStoryParagraph extends AbstractEntity {

    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String header;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String body;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String footer;
    @ManyToOne
    @JoinColumn(name = "news_story_id", nullable = false)
    private NewsStory newsStory;

    public NewsStoryParagraph() {
    }

    public NewsStory getNewsStory() {
        return this.newsStory;
    }

    public void setNewsStory(NewsStory newsStory) {
        this.newsStory = newsStory;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return this.footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

}
