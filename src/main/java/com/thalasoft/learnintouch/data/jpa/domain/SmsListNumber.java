package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_sms_list_number")
public class SmsListNumber extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "sms_list_id", nullable = false)
    private SmsList smsList;
    @ManyToOne
    @JoinColumn(name = "sms_number_id", nullable = false)
    private SmsNumber smsNumber;

    public SmsListNumber() {
    }

    public SmsNumber getSmsNumber() {
        return this.smsNumber;
    }

    public void setSmsNumber(SmsNumber smsNumber) {
        this.smsNumber = smsNumber;
    }

    public SmsList getSmsList() {
        return this.smsList;
    }

    public void setSmsList(SmsList smsList) {
        this.smsList = smsList;
    }

}
