package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_photo_album")
public class PhotoAlbum extends AbstractEntity {

   @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String folderName;
    private String event;
    private String location;
    private int price;
    @Column(nullable = false)
    private int listOrder;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(length = 10)
    private LocalDateTime publicationDate;
    @Column(nullable = false)
    private boolean hide;
    @Column(nullable = false)
    private boolean no_slide_show;
    @Column(nullable = false)
    private boolean no_zoom;

    public PhotoAlbum() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public boolean getHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean getNoSlideShow() {
        return no_slide_show;
    }

    public void setNoSlideShow(boolean no_slide_show) {
        this.no_slide_show = no_slide_show;
    }

    public boolean getNoZoom() {
        return no_zoom;
    }

    public void setNoZoom(boolean no_zoom) {
        this.no_zoom = no_zoom;
    }

}
