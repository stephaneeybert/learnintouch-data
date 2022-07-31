package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_container")
public class TemplateContainer extends AbstractEntity {

    @Column(nullable = false)
    private int rowNb;
    @Column(nullable = false)
    private int cellNb;
    @ManyToOne
    @JoinColumn(name = "template_model_id", nullable = false)
    private TemplateModel templateModel;
    @ManyToOne
    @JoinColumn(name = "template_property_set_id")
    private TemplatePropertySet templatePropertySet;

    public TemplateContainer() {
    }

    public int getRowNb() {
        return this.rowNb;
    }

    public void setRowNb(int row_nb) {
        this.rowNb = row_nb;
    }

    public int getCellNb() {
        return this.cellNb;
    }

    public void setCellNb(int cell_nb) {
        this.cellNb = cell_nb;
    }

    public TemplateModel getTemplateModel() {
        return this.templateModel;
    }

    public void setTemplateModel(TemplateModel templateModel) {
        this.templateModel = templateModel;
    }

    public TemplatePropertySet getTemplatePropertySet() {
        return this.templatePropertySet;
    }

    public void setTemplatePropertySet(TemplatePropertySet templatePropertySet) {
        this.templatePropertySet = templatePropertySet;
    }

}
