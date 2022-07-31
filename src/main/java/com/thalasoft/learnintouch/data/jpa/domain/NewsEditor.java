package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_news_editor")
public class NewsEditor extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "admin_id", nullable = false, unique = true)
    private Admin admin;

    public NewsEditor() {
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
