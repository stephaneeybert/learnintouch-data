package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_navbar_language")
public class NavbarLanguage extends AbstractEntity {

    @Column(length = 2)
    private String languageCode;
    @ManyToOne
    @JoinColumn(name = "navbar_id", nullable = false)
    private Navbar navbar;

    public NavbarLanguage() {
    }

    public Navbar getNavbar() {
        return this.navbar;
    }

    public void setNavbar(Navbar navbar) {
        this.navbar = navbar;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

}
