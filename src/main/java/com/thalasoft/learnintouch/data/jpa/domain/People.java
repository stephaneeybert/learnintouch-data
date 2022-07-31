package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_people")
public class People extends AbstractEntity {

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private String email;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String profile;
    @Column(length = 255)
    private String image;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private PeopleCategory peopleCategory;

    public People() {
    }

    public PeopleCategory getPeopleCategory() {
        return this.peopleCategory;
    }

    public void setPeopleCategory(PeopleCategory peopleCategory) {
        this.peopleCategory = peopleCategory;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
