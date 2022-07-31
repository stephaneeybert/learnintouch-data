package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_mail_outbox")
public class MailOutbox extends AbstractEntity {

    private String firstname;
    private String lastname;
    @Column(nullable = false)
    private String email;
    @Column(length = 20)
    private String password;
    @Column(nullable = false)
    private boolean sent;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String metaNames;

    public MailOutbox() {
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getSent() {
        return this.sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getMetaNames() {
        return this.metaNames;
    }

    public void setMetaNames(String metaNames) {
        this.metaNames = metaNames;
    }

}
