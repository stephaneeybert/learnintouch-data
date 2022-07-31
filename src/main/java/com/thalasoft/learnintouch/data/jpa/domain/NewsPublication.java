package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_publication")
public class NewsPublication extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    private String description;
    private int nbColumns;
    @Column(nullable = false)
    private boolean slideDown;
    @Column(length = 10)
    private String align;
    @Column(nullable = false)
    private boolean withArchive;
    @Column(nullable = false)
    private boolean withOthers;
    @Column(nullable = false)
    private boolean withByHeading;
    @Column(nullable = false)
    private boolean hideHeading;
    @Column(nullable = false)
    private boolean secured;
    private int autoArchive;
    private int autoDelete;

    public NewsPublication() {
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

    public int getNbColumns() {
        return this.nbColumns;
    }

    public void setNbColumns(int nbColumns) {
        this.nbColumns = nbColumns;
    }

    public boolean isSlideDown() {
        return slideDown;
    }

    public void setSlideDown(boolean slideDown) {
        this.slideDown = slideDown;
    }

    public String getAlign() {
        return this.align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public boolean isWithArchive() {
        return withArchive;
    }

    public void setWithArchive(boolean withArchive) {
        this.withArchive = withArchive;
    }

    public boolean isWithOthers() {
        return withOthers;
    }

    public void setWithOthers(boolean withOthers) {
        this.withOthers = withOthers;
    }

    public boolean isWithByHeading() {
        return withByHeading;
    }

    public void setWithByHeading(boolean withByHeading) {
        this.withByHeading = withByHeading;
    }

    public boolean getHideHeading() {
        return hideHeading;
    }

    public void setHideHeading(boolean hideHeading) {
        this.hideHeading = hideHeading;
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public int getAutoArchive() {
        return this.autoArchive;
    }

    public void setAutoArchive(int autoArchive) {
        this.autoArchive = autoArchive;
    }

    public int getAutoDelete() {
        return this.autoDelete;
    }

    public void setAutoDelete(int autoDelete) {
        this.autoDelete = autoDelete;
    }

}
