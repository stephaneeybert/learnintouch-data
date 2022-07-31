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
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_guestbook_entry")
public class GuestbookEntry extends AbstractEntity {

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false, length = 65535)
    private String body;
    private String email;
    private String firstname;
    private String lastname;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime publicationDatetime;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    public GuestbookEntry() {
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public LocalDateTime getPublicationDatetime() {
        return this.publicationDatetime;
    }

    public void setPublicationDatetime(LocalDateTime publicationDatetime) {
        this.publicationDatetime = publicationDatetime;
    }

}
