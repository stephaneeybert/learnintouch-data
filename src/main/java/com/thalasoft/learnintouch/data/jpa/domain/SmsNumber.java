package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_sms_number")
public class SmsNumber extends AbstractEntity {

    private String firstname;
    private String lastname;
    @Column(nullable = false, length = 20)
    private String mobilePhone;
    @Column(nullable = false)
    private boolean subscribe;
    @Column(nullable = false)
    private boolean imported;

    public SmsNumber() {
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

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public boolean getSubscribe() {
        return this.subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public boolean getImported() {
        return this.imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

}
