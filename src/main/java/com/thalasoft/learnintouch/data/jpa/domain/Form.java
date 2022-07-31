package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_form")
public class Form extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    private String description;
    private String title;
    @Column(length = 255)
    private String image;
    private String email;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String instructions;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String acknowledge;
    private String webpageId;
    private String mailSubject;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String mailMessage;

    public Form() {
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getAcknowledge() {
        return this.acknowledge;
    }

    public void setAcknowledge(String acknowledge) {
        this.acknowledge = acknowledge;
    }

    public String getWebpageId() {
        return this.webpageId;
    }

    public void setWebpageId(String webpageId) {
        this.webpageId = webpageId;
    }

    public String getMailSubject() {
        return this.mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailMessage() {
        return this.mailMessage;
    }

    public void setMailMessage(String mailMessage) {
        this.mailMessage = mailMessage;
    }

}
