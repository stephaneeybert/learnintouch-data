package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_category")
public class ElearningCategory extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    private String description;

    public ElearningCategory() {
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

}
