package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_mail_address")
public class MailAddress extends AbstractEntity {

    private String firstname;
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String textComment;
    private String country;
    @Column(nullable = false)
    private boolean subscribe;
    @Column(nullable = false)
    private boolean imported;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime creationDatetime;

    public MailAddress() {
        this.creationDatetime = new LocalDateTime();
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

    public String getTextComment() {
        return this.textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getSubscribe() {
        return this.subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public boolean getImported() {
        return this.imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public LocalDateTime getCreationDatetime() {
        return this.creationDatetime;
    }

    public void setCreationDatetime(LocalDateTime creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

}
