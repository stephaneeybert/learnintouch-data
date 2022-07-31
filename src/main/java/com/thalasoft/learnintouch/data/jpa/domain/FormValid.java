package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_form_valid")
public class FormValid extends AbstractEntity {

    @Column(nullable = false, length = 30)
    private String type;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String message;
    @Column(length = 20)
    private String boundary;
    @ManyToOne
    @JoinColumn(name = "form_item_id", nullable = false)
    private FormItem formItem;

    public FormValid() {
    }

    public FormItem getFormItem() {
        return this.formItem;
    }

    public void setFormItem(FormItem formItem) {
        this.formItem = formItem;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBoundary() {
        return this.boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }

}
