package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_social_user")
public class SocialUser extends AbstractEntity {

    @Column(unique = true)
    private String facebookUserId;
    @Column(unique = true)
    private String linkedinUserId;
    @Column(unique = true)
    private String googleUserId;
    @Column(unique = true)
    private String twitterUserId;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    public SocialUser() {
    }

    public String getFacebookUserId() {
        return this.facebookUserId;
    }

    public void setFacebookUserId(String facebookUserId) {
        this.facebookUserId = facebookUserId;
    }

    protected String getLinkedinUserId() {
        return linkedinUserId;
    }

    protected void setLinkedinUserId(String linkedinUserId) {
        this.linkedinUserId = linkedinUserId;
    }

    public String getGoogleUserId() {
        return googleUserId;
    }

    public void setGoogleUserId(String googleUserId) {
        this.googleUserId = googleUserId;
    }

    public String getTwitterUserId() {
        return twitterUserId;
    }

    public void setTwitterUserId(String twitterUserId) {
        this.twitterUserId = twitterUserId;
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

}
