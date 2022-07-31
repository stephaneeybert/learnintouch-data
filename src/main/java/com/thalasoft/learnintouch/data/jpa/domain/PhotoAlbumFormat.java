package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_photo_album_format")
public class PhotoAlbumFormat extends AbstractEntity {

    @Column(nullable = false)
    private int price;
    @ManyToOne
    @JoinColumn(name = "photo_format_id", nullable = false)
    private PhotoFormat photoFormat;
    @ManyToOne
    @JoinColumn(name = "photo_album_id", nullable = false)
    private PhotoAlbum photoAlbum;

    public PhotoAlbumFormat() {
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

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
