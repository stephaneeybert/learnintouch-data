package com.thalasoft.learnintouch.data.jpa.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_link_category")
public class LinkCategory extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    private String description;
    @Column(nullable = false)
    private int listOrder;
    @OneToMany(mappedBy = "linkCategory", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderColumn(name = "listOrder")
    private Collection<Link> links;

    public LinkCategory() {
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
        return listOrder;
    }
    
    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    public Collection<Link> getLinks() {
        return links;
    }

    public void setLinks(Collection<Link> links) {
        this.links = links;
    }

}
