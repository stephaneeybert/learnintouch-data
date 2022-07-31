package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_page")
public class TemplatePage extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String systemPage;
    @ManyToOne
    @JoinColumn(name = "template_model_id", nullable = false)
    private TemplateModel templateModel;

    public TemplatePage() {
    }

    public String getSystemPage() {
        return this.systemPage;
    }

    public void setSystemPage(String systemPage) {
        this.systemPage = systemPage;
    }

    public TemplateModel getTemplateModel() {
        return this.templateModel;
    }

    public void setTemplateModel(TemplateModel templateModel) {
        this.templateModel = templateModel;
    }

}
