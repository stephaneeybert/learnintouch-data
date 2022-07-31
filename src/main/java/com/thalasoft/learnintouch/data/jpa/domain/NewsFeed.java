package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_feed")
public class NewsFeed extends AbstractEntity {

    @Column(length = 255)
    private String image;
    private int maxDisplayNumber;
    @Column(length = 10)
    private String imageAlign;
    private int imageWidth;
    private boolean withExcerpt;
    private boolean withImage;
    private boolean searchOptions;
    private boolean searchCalendar;
    @Column(length = 255)
    private String searchTitle;
    private boolean searchDisplayAsPage;
    @ManyToOne
    @JoinColumn(name = "news_paper_id", nullable = false)
    private NewsPaper newsPaper;

    public NewsFeed() {
    }

    public NewsPaper getNewsPaper() {
        return this.newsPaper;
    }

    public void setNewsPaper(NewsPaper newsPaper) {
        this.newsPaper = newsPaper;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMaxDisplayNumber() {
        return this.maxDisplayNumber;
    }

    public void setMaxDisplayNumber(int maxDisplayNumber) {
        this.maxDisplayNumber = maxDisplayNumber;
    }

    public String getImageAlign() {
        return imageAlign;
    }

    public void setImageAlign(String imageAlign) {
        this.imageAlign = imageAlign;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public boolean isWithExcerpt() {
        return withExcerpt;
    }

    public void setWithExcerpt(boolean withExcerpt) {
        this.withExcerpt = withExcerpt;
    }

    protected boolean isWithImage() {
        return withImage;
    }

    protected void setWithImage(boolean withImage) {
        this.withImage = withImage;
    }

    protected boolean isSearchOptions() {
        return searchOptions;
    }

    protected void setSearchOptions(boolean searchOptions) {
        this.searchOptions = searchOptions;
    }

    protected boolean isSearchCalendar() {
        return searchCalendar;
    }

    protected void setSearchCalendar(boolean searchCalendar) {
        this.searchCalendar = searchCalendar;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    protected boolean isSearchDisplayAsPage() {
        return searchDisplayAsPage;
    }

    protected void setSearchDisplayAsPage(boolean searchDisplayAsPage) {
        this.searchDisplayAsPage = searchDisplayAsPage;
    }

}
