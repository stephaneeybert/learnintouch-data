package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_sms_history")
public class SmsHistory extends AbstractEntity {

    @Column(length = 50)
    private String mobilePhone;
    private int nbRecipients;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime sendDatetime;
    @ManyToOne
    @JoinColumn(name = "sms_id", nullable = false)
    private Sms sms;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @ManyToOne
    @JoinColumn(name = "sms_list_id")
    private SmsList smsList;

    public SmsHistory() {
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public SmsList getSmsList() {
        return this.smsList;
    }

    public void setSmsList(SmsList smsList) {
        this.smsList = smsList;
    }

    public Sms getSms() {
        return this.sms;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public LocalDateTime getSendDatetime() {
        return this.sendDatetime;
    }

    public void setSendDatetime(LocalDateTime sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public int getNbRecipients() {
        return this.nbRecipients;
    }

    public void setNbRecipients(int nbRecipients) {
        this.nbRecipients = nbRecipients;
    }

}
