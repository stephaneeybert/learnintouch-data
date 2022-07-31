package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_contact_referer")
public class ContactReferer extends AbstractEntity {

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false, length = 65535)
    private String description;
    @Column(nullable = false)
    private int listOrder;

    public ContactReferer() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getListOrder() {
    	return this.listOrder;
    }
    
    public void setListOrder(int listOrder) {
    	this.listOrder = listOrder;
    }
    
}
