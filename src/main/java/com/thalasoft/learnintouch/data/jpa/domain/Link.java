package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_link")
public class Link extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    private String description;
    @Column(length = 255)
    private String image;
    private String url;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private LinkCategory linkCategory;

    public Link() {
    }

    public LinkCategory getLinkCategory() {
        return this.linkCategory;
    }

    public void setLinkCategory(LinkCategory linkCategory) {
        this.linkCategory = linkCategory;
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

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
