package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_mail_list_user")
public class MailListUser extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;
    @ManyToOne
    @JoinColumn(name = "mail_list_id", nullable = false)
    private MailList mailList;

    public MailListUser() {
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public MailList getMailList() {
        return this.mailList;
    }

    public void setMailList(MailList mailList) {
        this.mailList = mailList;
    }

}
