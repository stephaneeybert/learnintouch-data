package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_webpage_navmenu")
public class WebpageNavmenu extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private WebpageNavmenu parent;

    public WebpageNavmenu() {
    }

    public WebpageNavmenu getParent() {
        return parent;
    }

    public void setParent(WebpageNavmenu parent) {
        this.parent = parent;
    }

}
