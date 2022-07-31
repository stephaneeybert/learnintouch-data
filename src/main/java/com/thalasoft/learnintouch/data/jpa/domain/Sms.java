package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_sms")
public class Sms extends AbstractEntity {

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false, length = 65535)
    private String body;
    private String description;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private SmsCategory smsCategory;

    public Sms() {
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public SmsCategory getSmsCategory() {
        return this.smsCategory;
    }

    public void setSmsCategory(SmsCategory smsCategory) {
        this.smsCategory = smsCategory;
    }

}
