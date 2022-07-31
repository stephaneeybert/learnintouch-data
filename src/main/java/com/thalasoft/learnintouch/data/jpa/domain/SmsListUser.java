package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_sms_list_user")
public class SmsListUser extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "sms_list_id", nullable = false)
    private SmsList smsList;
    @ManyToOne
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;

    public SmsListUser() {
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public SmsList getSmsList() {
        return this.smsList;
    }

    public void setSmsList(SmsList smsList) {
        this.smsList = smsList;
    }

}
