package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_element_tag")
public class TemplateElementTag extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String domTagId;
    @ManyToOne
    @JoinColumn(name = "template_element_id", nullable = false)
    private TemplateElement templateElement;
    @ManyToOne
    @JoinColumn(name = "template_property_set_id")
    private TemplatePropertySet templatePropertySet;

    public TemplateElementTag() {
    }

    public String getDomTagId() {
        return this.domTagId;
    }

    public void setDomTagId(String domTagId) {
        this.domTagId = domTagId;
    }

    public TemplateElement getTemplateElement() {
        return this.templateElement;
    }

    public void setTemplateElement(TemplateElement templateElement) {
        this.templateElement = templateElement;
    }

    public TemplatePropertySet getTemplatePropertySet() {
        return this.templatePropertySet;
    }

    public void setTemplatePropertySet(TemplatePropertySet templatePropertySet) {
        this.templatePropertySet = templatePropertySet;
    }

}
