package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_preference")
public class Preference extends AbstractEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String value;
    @Column(nullable = false)
    private int type;

    public Preference() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
