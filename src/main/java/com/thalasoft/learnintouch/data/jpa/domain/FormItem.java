package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_form_item")
public class FormItem extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String type;
    @Column(length = 50)
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String text;
    private String help;
    @Column(length = 50)
    private String defaultValue;
    @Column(length = 3)
    private String itemSize;
    @Column(length = 4)
    private String maxlength;
    @Column(nullable = false)
    private boolean inMailAddress;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "mail_list_id")
    private MailList mailList;
    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private Form form;

    public FormItem() {
    }

    public MailList getMailList() {
        return this.mailList;
    }

    public void setMailList(MailList mailList) {
        this.mailList = mailList;
    }

    public Form getForm() {
        return this.form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHelp() {
        return this.help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getItemSize() {
        return this.itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getMaxlength() {
        return this.maxlength;
    }

    public void setMaxlength(String maxlength) {
        this.maxlength = maxlength;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public boolean getInMailAddress() {
        return this.inMailAddress;
    }

    public void setInMailAddress(boolean inMailAddress) {
        this.inMailAddress = inMailAddress;
    }

}
