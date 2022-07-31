package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_model")
public class TemplateModel extends AbstractEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String name;
    private String description;
    @Column(nullable = false, length = 50)
    private String modelType;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TemplateModel parent;
    @ManyToOne
    @JoinColumn(name = "template_property_set_id")
    private TemplatePropertySet templatePropertySet;
    @ManyToOne
    @JoinColumn(name = "inner_template_property_set_id")
    private TemplatePropertySet innerTemplatePropertySet;

    public TemplateModel() {
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

    public String getModelType() {
        return this.modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public TemplateModel getParent() {
		return parent;
	}

	public void setParent(TemplateModel parent) {
		this.parent = parent;
	}

	public TemplatePropertySet getTemplatePropertySet() {
        return this.templatePropertySet;
    }

    public void setTemplatePropertySet(TemplatePropertySet templatePropertySet) {
        this.templatePropertySet = templatePropertySet;
    }

    public TemplatePropertySet getInnerTemplatePropertySet() {
        return this.innerTemplatePropertySet;
    }

    public void setInnerTemplatePropertySet(TemplatePropertySet innerTemplatePropertySet) {
        this.innerTemplatePropertySet = innerTemplatePropertySet;
    }

}
