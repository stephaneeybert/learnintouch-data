package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_element")
public class TemplateElement extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String elementType;
    @Column(nullable = false)
    private int listOrder;
    @Column(nullable = false)
    private boolean hide;
    private long objectId;
    @ManyToOne
    @JoinColumn(name = "template_container_id", nullable = false)
    private TemplateContainer templateContainer;

    public TemplateElement() {
    }

    public String getElementType() {
        return this.elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public boolean getHide() {
        return this.hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public long getObjectId() {
        return this.objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public TemplateContainer getTemplateContainer() {
        return this.templateContainer;
    }

    public void setTemplateContainer(TemplateContainer templateContainer) {
        this.templateContainer = templateContainer;
    }

}
