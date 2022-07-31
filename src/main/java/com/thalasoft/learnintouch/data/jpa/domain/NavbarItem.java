package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_navbar_item")
public class NavbarItem extends AbstractEntity {

    @Column(length = 255)
    private String name;
    private String description;
    @Column(length = 255)
    private String image;
    @Column(length = 255)
    private String imageOver;
    private String url;
    @Column(nullable = false)
    private boolean blankTarget;
    @Column(nullable = false)
    private boolean hide;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "navbar_language_id", nullable = false)
    private NavbarLanguage navbarLanguage;
    @ManyToOne
    @JoinColumn(name = "template_model_id")
    private TemplateModel templateModel;

    public NavbarItem() {
    }

    public NavbarLanguage getNavbarLanguage() {
        return this.navbarLanguage;
    }

    public void setNavbarLanguage(NavbarLanguage navbarLanguage) {
        this.navbarLanguage = navbarLanguage;
    }

    public TemplateModel getTemplateModel() {
        return this.templateModel;
    }

    public void setTemplateModel(TemplateModel templateModel) {
        this.templateModel = templateModel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageOver() {
        return this.imageOver;
    }

    public void setImageOver(String imageOver) {
        this.imageOver = imageOver;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getBlankTarget() {
        return this.blankTarget;
    }

    public void setBlankTarget(boolean blankTarget) {
        this.blankTarget = blankTarget;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getHide() {
        return this.hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
