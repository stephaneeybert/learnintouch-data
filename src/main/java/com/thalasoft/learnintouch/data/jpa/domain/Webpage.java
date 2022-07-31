package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_webpage")
public class Webpage extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    private String description;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Column(nullable = false)
    private boolean hide;
    @Column(nullable = false)
    private boolean garbage;
    @Column(nullable = false)
    private int listOrder;
    @Column(nullable = false)
    private boolean secured;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Webpage parent;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Webpage() {
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

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getHide() {
        return this.hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean getGarbage() {
        return this.garbage;
    }

    public void setGarbage(boolean garbage) {
        this.garbage = garbage;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public Webpage getParent() {
        return parent;
    }

    public void setParent(Webpage parent) {
        this.parent = parent;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
