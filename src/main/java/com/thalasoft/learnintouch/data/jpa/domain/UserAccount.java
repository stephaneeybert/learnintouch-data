package com.thalasoft.learnintouch.data.jpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_user_account")
public class UserAccount extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(nullable = false, unique = true)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private String organisation;
    @Column(nullable = false, unique = true)
    private EmailAddress email;
    @Column(length = 20)
    private String fax;
    @Column(length = 20)
    private String homePhone;
    @Column(length = 20)
    private String workPhone;
    @Column(length = 20)
    private String mobilePhone;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String passwordSalt;
    @Column(length = 50)
    private String readablePassword;
    @Column(nullable = false)
    private boolean unconfirmedEmail;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime validUntil;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime lastLogin;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String profile;
    @Column(length = 255)
    private String image;
    @Column(nullable = false)
    private boolean imported;
    @Column(nullable = false)
    private boolean mailSubscribe;
    @Column(nullable = false)
    private boolean smsSubscribe;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime creationDatetime;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "userAccount", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<UserRole> userRoles = new HashSet<>();

    public UserAccount() {
        this.creationDatetime = new LocalDateTime();
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public String getOrganisation() {
        return this.organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public EmailAddress getEmail() {
        return this.email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return this.workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getReadablePassword() {
        return this.readablePassword;
    }

    public void setReadablePassword(String readablePassword) {
        this.readablePassword = readablePassword;
    }

    public boolean isUnconfirmedEmail() {
        return unconfirmedEmail;
    }

    public void setUnconfirmedEmail(boolean unconfirmedEmail) {
        this.unconfirmedEmail = unconfirmedEmail;
    }

    public LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
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

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public boolean isMailSubscribe() {
        return this.mailSubscribe;
    }

    public void setMailSubscribe(boolean mailSubscribe) {
        this.mailSubscribe = mailSubscribe;
    }

    public boolean isSmsSubscribe() {
        return this.smsSubscribe;
    }

    public void setSmsSubscribe(boolean smsSubscribe) {
        this.smsSubscribe = smsSubscribe;
    }

    public LocalDateTime getCreationDatetime() {
        return this.creationDatetime;
    }

    public void setCreationDatetime(LocalDateTime creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public Set<UserRole> getUserRoles() {
      return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
      if (this.userRoles == null) {
        this.userRoles = userRoles;
      } else {
        this.userRoles.clear();
        this.userRoles.addAll(userRoles);
      }
    }

}
