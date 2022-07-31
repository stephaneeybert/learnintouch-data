package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_contact")
public class Contact extends AbstractEntity {

    private String firstname;
    private String lastname;
    @Column(nullable = false)
    private String email;
    private String organisation;
    @Column(length = 20)
    private String telephone;
    private String subject;
    @Lob
    @Column(columnDefinition = "TEXT", nullable = false, length = 65535)
    private String message;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime contactDatetime;
    @Column(nullable = false)
    private boolean garbage;
    @ManyToOne
    @JoinColumn(name = "contact_referer_id")
    private ContactReferer contactReferer;
    @ManyToOne
    @JoinColumn(name = "contact_status_id")
    private ContactStatus contactStatus;

    public Contact() {
    }

    public ContactStatus getContactStatus() {
        return this.contactStatus;
    }

    public void setContactStatus(ContactStatus contactStatus) {
        this.contactStatus = contactStatus;
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

    public String getOrganisation() {
        return this.organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getContactDatetime() {
        return this.contactDatetime;
    }

    public void setContactDatetime(LocalDateTime contactDatetime) {
        this.contactDatetime = contactDatetime;
    }

    public ContactReferer getContactReferer() {
        return this.contactReferer;
    }

    public void setContactReferer(ContactReferer contactReferer) {
        this.contactReferer = contactReferer;
    }

    public boolean getGarbage() {
        return this.garbage;
    }

    public void setGarbage(boolean garbage) {
        this.garbage = garbage;
    }

}
