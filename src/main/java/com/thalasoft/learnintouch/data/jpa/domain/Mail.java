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
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_mail")
public class Mail extends AbstractEntity {

    private String subject;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String body;
    private String description;
    @Column(nullable = false)
    private boolean textFormat;
    @Column(nullable = false)
    private boolean locked;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String attachments;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime creationDatetime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime sendDatetime;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private MailCategory mailCategory;

    public Mail() {
        this.creationDatetime = new LocalDateTime();
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public MailCategory getMailCategory() {
        return this.mailCategory;
    }

    public void setMailCategory(MailCategory mailCategory) {
        this.mailCategory = mailCategory;
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

    public boolean isTextFormat() {
        return this.textFormat;
    }

    public void setTextFormat(boolean textFormat) {
        this.textFormat = textFormat;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getAttachments() {
        return this.attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public LocalDateTime getCreationDatetime() {
        return this.creationDatetime;
    }

    public void setCreationDatetime(LocalDateTime creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public LocalDateTime getSendDatetime() {
        return this.sendDatetime;
    }

    public void setSendDatetime(LocalDateTime sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

}
