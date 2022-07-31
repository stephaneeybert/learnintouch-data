package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_property")
public class TemplateProperty extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String value;
    @ManyToOne
    @JoinColumn(name = "template_property_set_id", nullable = false)
    private TemplatePropertySet templatePropertySet;

    public TemplateProperty() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TemplatePropertySet getTemplatePropertySet() {
        return this.templatePropertySet;
    }

    public void setTemplatePropertySet(TemplatePropertySet templatePropertySet) {
        this.templatePropertySet = templatePropertySet;
    }

}
