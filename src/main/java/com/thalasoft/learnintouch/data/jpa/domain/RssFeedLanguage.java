package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_rss_feed_language")
public class RssFeedLanguage extends AbstractEntity {

    @Column(length = 2)
    private String languageCode;
    @Column(length = 50)
    private String title;
    @Column(length = 255)
    private String url;
    @ManyToOne
    @JoinColumn(name = "rss_feed_id", nullable = false)
    private RssFeed rssFeed;

    public RssFeedLanguage() {
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String language) {
        this.languageCode = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RssFeed getRssFeed() {
        return this.rssFeed;
    }

    public void setRssFeed(RssFeed rssFeed) {
        this.rssFeed = rssFeed;
    }

}
