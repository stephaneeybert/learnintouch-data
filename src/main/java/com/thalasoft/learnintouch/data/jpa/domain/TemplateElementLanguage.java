package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_t_e_language")
public class TemplateElementLanguage extends AbstractEntity {

    @Column(length = 2)
    private String languageCode;
    private long objectId;
    @ManyToOne
    @JoinColumn(name = "template_element_id", nullable = false)
    private TemplateElement templateElement;

    public TemplateElementLanguage() {
    }

    protected String getLanguageCode() {
        return languageCode;
    }

    protected void setLanguageCode(String language) {
        this.languageCode = language;
    }

    public long getObjectId() {
        return this.objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public TemplateElement getTemplateElement() {
        return this.templateElement;
    }

    public void setTemplateElement(TemplateElement templateElement) {
        this.templateElement = templateElement;
    }

}
