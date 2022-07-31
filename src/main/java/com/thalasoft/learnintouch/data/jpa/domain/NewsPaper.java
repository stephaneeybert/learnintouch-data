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
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_paper")
public class NewsPaper extends AbstractEntity {

    @Column(nullable = false)
    private String title;
    @Column(length = 255)
    private String image;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String header;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String footer;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime releaseDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime archiveDate;
    @Column(nullable = false)
    private boolean notPublished;
    @ManyToOne
    @JoinColumn(name = "news_publication_id")
    private NewsPublication newsPublication;

    public NewsPaper() {
    }

    public NewsPublication getNewsPublication() {
        return this.newsPublication;
    }

    public void setNewsPublication(NewsPublication newsPublication) {
        this.newsPublication = newsPublication;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return this.footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
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

    public boolean getNotPublished() {
        return this.notPublished;
    }

    public void setNotPublished(boolean notPublished) {
        this.notPublished = notPublished;
    }

}
