package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_flash")
public class Flash extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String filename;
    @Column(length = 10)
    private String width;
    @Column(length = 10)
    private String height;
    @Column(length = 10)
    private String bgcolor;
    @Column(length = 50)
    private String wddx;

    public Flash() {
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getWidth() {
        return this.width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBgcolor() {
        return this.bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public String getWddx() {
        return this.wddx;
    }

    public void setWddx(String wddx) {
        this.wddx = wddx;
    }

}
