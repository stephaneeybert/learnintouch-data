package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_photo")
public class Photo extends AbstractEntity {

    @Column(length = 50)
    private String name;
    @Column(length = 255)
    private String description;
    @Column(length = 255)
    private String tags;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String textComment;
    @Column(length = 255)
    private String image;
    @Column(length = 50)
    private String reference;
    private String url;
    private int price;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "photo_format_id")
    private PhotoFormat photoFormat;
    @ManyToOne
    @JoinColumn(name = "photo_album_id")
    private PhotoAlbum photoAlbum;

    public Photo() {
    }

    public PhotoFormat getPhotoFormat() {
        return this.photoFormat;
    }

    public void setPhotoFormat(PhotoFormat photoFormat) {
        this.photoFormat = photoFormat;
    }

    public PhotoAlbum getPhotoAlbum() {
        return this.photoAlbum;
    }

    public void setPhotoAlbum(PhotoAlbum photoAlbum) {
        this.photoAlbum = photoAlbum;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
    
    public String getTags() {
        return tags;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTextComment() {
        return this.textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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

}
