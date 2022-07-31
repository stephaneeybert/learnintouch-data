package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_mail_list_address")
public class MailListAddress extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "mail_list_id", nullable = false)
    private MailList mailList;
    @ManyToOne
    @JoinColumn(name = "mail_address_id", nullable = false)
    private MailAddress mailAddress;

    public MailListAddress() {
    }

    public MailList getMailList() {
        return this.mailList;
    }

    public void setMailList(MailList mailList) {
        this.mailList = mailList;
    }

    public MailAddress getMailAddress() {
        return this.mailAddress;
    }

    public void setMailAddress(MailAddress mailAddress) {
        this.mailAddress = mailAddress;
    }

}
