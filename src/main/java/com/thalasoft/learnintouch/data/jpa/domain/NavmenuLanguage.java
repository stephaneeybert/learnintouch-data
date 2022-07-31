package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_navmenu_language")
public class NavmenuLanguage extends AbstractEntity {

    @Column(length = 2)
    private String languageCode;
    @ManyToOne
    @JoinColumn(name = "navmenu_id", nullable = false)
    private Navmenu navmenu;
    @ManyToOne
    @JoinColumn(name = "navmenu_item_id", nullable = false)
    private NavmenuItem navmenuItem;

    public NavmenuLanguage() {
    }

    public Navmenu getNavmenu() {
        return this.navmenu;
    }

    public void setNavmenu(Navmenu navmenu) {
        this.navmenu = navmenu;
    }

    public NavmenuItem getNavmenuItem() {
        return this.navmenuItem;
    }

    public void setNavmenuItem(NavmenuItem navmenuItem) {
        this.navmenuItem = navmenuItem;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String language) {
        this.languageCode = language;
    }

}
