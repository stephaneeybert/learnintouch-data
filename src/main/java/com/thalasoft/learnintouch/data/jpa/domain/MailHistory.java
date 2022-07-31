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
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_mail_history")
public class MailHistory extends AbstractEntity {

    @Column(nullable = false)
    private String subject;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String body;
    private String description;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String attachments;
    private String email;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime sendDatetime;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @ManyToOne
    @JoinColumn(name = "mail_list_id")
    private MailList mailList;

    public MailHistory() {
    }

    public MailList getMailList() {
        return this.mailList;
    }

    public void setMailList(MailList mailList) {
        this.mailList = mailList;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getAttachments() {
        return this.attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getSendDatetime() {
        return this.sendDatetime;
    }

    public void setSendDatetime(LocalDateTime sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

}
