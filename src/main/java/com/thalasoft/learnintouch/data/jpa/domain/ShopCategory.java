package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_shop_category")
public class ShopCategory extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    private String description;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ShopCategory parent;

    public ShopCategory() {
    }

    public ShopCategory getParent() {
        return this.parent;
    }

    public void setParent(ShopCategory parent) {
        this.parent = parent;
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

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
