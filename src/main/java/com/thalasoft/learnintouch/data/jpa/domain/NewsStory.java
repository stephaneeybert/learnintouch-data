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
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_story")
public class NewsStory extends AbstractEntity {

    @Column(nullable = false)
    private String headline;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String excerpt;
    @Column(length = 255)
    private String audio;
    @Column(length = 255)
    private String audioUrl;
    private String link;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime releaseDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime archiveDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime eventStartDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime eventEndDate;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "news_editor_id")
    private NewsEditor newsEditor;
    @ManyToOne
    @JoinColumn(name = "news_paper_id", nullable = false)
    private NewsPaper newsPaper;
    @ManyToOne
    @JoinColumn(name = "news_heading_id")
    private NewsHeading newsHeading;

    public NewsStory() {
    }

    public String getHeadline() {
        return this.headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getExcerpt() {
        return this.excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getAudio() {
        return this.audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getArchiveDate() {
        return this.archiveDate;
    }

    public void setArchiveDate(LocalDateTime archive) {
        this.archiveDate = archive;
    }

    public LocalDateTime getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(LocalDateTime eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public LocalDateTime getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(LocalDateTime eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public NewsEditor getNewsEditor() {
        return this.newsEditor;
    }

    public void setNewsEditor(NewsEditor newsEditor) {
        this.newsEditor = newsEditor;
    }

    public NewsPaper getNewsPaper() {
        return this.newsPaper;
    }

    public void setNewsPaper(NewsPaper newsPaper) {
        this.newsPaper = newsPaper;
    }

    public NewsHeading getNewsHeading() {
        return this.newsHeading;
    }

    public void setNewsHeading(NewsHeading newsHeading) {
        this.newsHeading = newsHeading;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
