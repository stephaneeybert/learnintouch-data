package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_navbar")
public class Navbar extends AbstractEntity {

    @Column(nullable = false)
    private boolean hide;

    public Navbar() {
    }

    public boolean getHide() {
        return this.hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

}
