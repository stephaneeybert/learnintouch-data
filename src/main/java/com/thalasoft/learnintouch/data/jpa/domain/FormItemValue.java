package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_form_item_value")
public class FormItemValue extends AbstractEntity {

    @Column(length = 50)
    private String value;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String text;
    @ManyToOne
    @JoinColumn(name = "form_item_id", nullable = false)
    private FormItem formItem;

    public FormItemValue() {
    }

    public FormItem getFormItem() {
        return this.formItem;
    }

    public void setFormItem(FormItem formItem) {
        this.formItem = formItem;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
