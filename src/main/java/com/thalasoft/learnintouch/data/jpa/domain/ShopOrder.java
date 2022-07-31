package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_shop_order")
public class ShopOrder extends AbstractEntity {

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private String organisation;
    @Column(nullable = false)
    private String email;
    @Column(length = 20)
    private String telephone;
    @Column(length = 20)
    private String mobilePhone;
    @Column(length = 20)
    private String fax;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String message;
    private int handlingFee;
    @Column(length = 12)
    private String discountCode;
    @Column(length = 10)
    private String discountAmount;
    @Column(nullable = false, length = 3)
    private String currency;
    @Column(length = 50)
    private String invoiceNumber;
    @Column(length = 1024)
    private String invoiceNote;
    @Column(length = 2)
    private String invoiceLanguageCode;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false, length = 10)
    private LocalDateTime orderDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false, length = 10)
    private LocalDateTime dueDate;
    @Column(nullable = false, length = 20)
    private String clientIp;
    @Column(nullable = false, length = 10)
    private String status;
    @Column(nullable = false, length = 10)
    private String paymentType;
    @Column(length = 50)
    private String paymentTransactionId;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
    @ManyToOne
    @JoinColumn(name = "invoice_address_id", nullable = false)
    private Address invoiceAddress;

    public ShopOrder() {
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getInvoiceAddress() {
        return this.invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHandlingFee() {
        return this.handlingFee;
    }

    public void setHandlingFee(int handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNote() {
        return this.invoiceNote;
    }

    public void setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
    }

    public String getInvoiceLanguageCode() {
        return this.invoiceLanguageCode;
    }

    public void setInvoiceLanguageCode(String invoiceLanguageCode) {
        this.invoiceLanguageCode = invoiceLanguageCode;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTransactionId() {
        return this.paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

}
