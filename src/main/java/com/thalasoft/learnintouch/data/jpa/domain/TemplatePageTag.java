package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_page_tag")
public class TemplatePageTag extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String domTagId;
    @ManyToOne
    @JoinColumn(name = "template_property_set_id")
    private TemplatePropertySet templatePropertySet;
    @ManyToOne
    @JoinColumn(name = "template_page_id", nullable = false)
    private TemplatePage templatePage;

    public TemplatePageTag() {
    }

    public TemplatePropertySet getTemplatePropertySet() {
        return this.templatePropertySet;
    }

    public void setTemplatePropertySet(TemplatePropertySet templatePropertySet) {
        this.templatePropertySet = templatePropertySet;
    }

    public TemplatePage getTemplatePage() {
        return this.templatePage;
    }

    public void setTemplatePage(TemplatePage templatePage) {
        this.templatePage = templatePage;
    }

    public String getDomTagId() {
        return this.domTagId;
    }

    public void setDomTagId(String domTagId) {
        this.domTagId = domTagId;
    }

}
