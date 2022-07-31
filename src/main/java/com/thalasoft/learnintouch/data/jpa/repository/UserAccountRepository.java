package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.Address;
import com.thalasoft.learnintouch.data.jpa.domain.EmailAddress;
import com.thalasoft.learnintouch.data.jpa.domain.MailList;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

public interface UserAccountRepository extends GenericRepository<UserAccount, Long>, UserAccountRepositoryCustom {

  public UserAccount findByEmail(EmailAddress email);
  
  public UserAccount findByEmailAndPassword(EmailAddress email, String password);
  
  public UserAccount findByEmailAndReadablePassword(EmailAddress email, String readablePassword);
  
  public Page<UserAccount> findByUnconfirmedEmailIsTrue(Pageable page);

  public Page<UserAccount> findByUnconfirmedEmailIsFalse(Pageable page);

  @Query("SELECT ua FROM UserAccount ua ORDER BY ua.firstname")
  public Page<UserAccount> all(Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE LOWER(ua.firstname) LIKE LOWER(CONCAT(:searchTerm, '%')) OR LOWER(ua.lastname) LIKE LOWER(CONCAT(:searchTerm, '%')) ORDER BY ua.firstname")
  public Page<UserAccount> searchOnName(@Param("searchTerm") String searchTerm, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE LOWER(ua.firstname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(ua.lastname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(ua.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) ORDER BY ua.firstname")
  public Page<UserAccount> search(@Param("searchTerm") String searchTerm, Pageable page);

  @Modifying
  @Query("UPDATE UserAccount SET firstname = :firstname, lastname = :lastname, organisation = :organisation, email = :email, homePhone = :homePhone, workPhone = :workPhone, fax =  :fax, mobilePhone = :mobilePhone, readablePassword = :readablePassword, unconfirmedEmail = :unconfirmedEmail, validUntil = :validUntil, lastLogin = :lastLogin, profile = :profile, image = :image, imported = :imported, mailSubscribe = :mailSubscribe, smsSubscribe = :smsSubscribe, creationDatetime = :creationDatetime, address = :address WHERE id = :id")
  public void update(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("organisation") String organisation,
      @Param("email") String email, @Param("homePhone") String homePhone, @Param("workPhone") String workPhone, @Param("fax") String fax,
      @Param("mobilePhone") String mobilePhone, @Param("readablePassword") String readablePassword,
      @Param("unconfirmedEmail") boolean unconfirmedEmail, @Param("validUntil") String validUntil, @Param("lastLogin") String lastLogin,
      @Param("profile") String profile, @Param("image") String image, @Param("imported") boolean imported,
      @Param("mailSubscribe") boolean mailSubscribe, @Param("mailSubscribe") boolean smsSubscribe,
      @Param("lastLogin") String creationDatetime, @Param("address") Address address, @Param("id") Long id);

  @Modifying
  @Query("UPDATE UserAccount SET password = :password, passwordSalt = :passwordSalt, readablePassword = :readablePassword WHERE id = :id")
  public void updatePassword(@Param("password") String password, @Param("passwordSalt") String passwordSalt,
      @Param("readablePassword") String readablePassword, @Param("id") Long id);

  @Query("SELECT ua FROM UserAccount ua ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findThemAll(Pageable page);

  public UserAccount findByImage(String image);

  public UserAccount findByMobilePhone(String mobilePhone);

  @Query("SELECT ua FROM UserAccount ua, Address a WHERE ua.address.id = a.id AND ua.mailSubscribe = '1' AND LOWER(a.country) LIKE LOWER(CONCAT('%', :country, '%')) ORDER BY a.country, ua.lastname, ua.firstname")
  public Page<UserAccount> findMailSubscribersLikeCountry(String country, Pageable page);

  @Query("SELECT ua FROM UserAccount ua, MailListUser mlu WHERE mlu.userAccount.id = ua.id AND mlu.mailList = :mailList ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findByMailList(@Param("mailList") MailList mailList, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.mailSubscribe = '1' ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findAllMailSubscribers(Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.lastLogin IS NOT NULL AND ua.lastLogin >= :lastLoginSinceDate AND ua.lastLogin < :lastLoginUntilDate ORDER BY ua.lastLogin DESC")
  public Page<UserAccount> findLoggedInSince(@Param("lastLoginSinceDate") String lastLoginSinceDate,
      @Param("lastLoginUntilDate") String lastLoginUntilDate, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.mailSubscribe = '1' AND ua.validUntil IS NOT NULL AND ua.validUntil < :systemDate ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findMailSubscribersAndExpired(@Param("systemDate") String systemDate, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.mailSubscribe = '1' AND (ua.validUntil IS NULL OR (ua.validUntil IS NOT NULL AND ua.validUntil >= :systemDate)) AND ua.mobilePhone != '' ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findMailSubscribersAndCurrent(@Param("systemDate") String systemDate, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.smsSubscribe = '1' AND ua.validUntil IS NOT NULL AND ua.validUntil < :systemDate AND ua.mobilePhone != '' ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findSmsSubscribersAndExpired(@Param("systemDate") String systemDate, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.smsSubscribe = '1' AND (ua.validUntil IS NULL OR (ua.validUntil IS NOT NULL AND ua.validUntil >= :systemDate)) AND ua.mobilePhone != '' ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findSmsSubscribersAndCurrent(@Param("systemDate") String systemDate, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.smsSubscribe = '1' AND ua.mobilePhone != '' ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findSmsSubscribers(Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.validUntil IS NOT NULL AND ua.validUntil < :systemDate ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findNotValid(@Param("systemDate") String systemDate, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.validUntil IS NOT NULL AND ua.validUntil >= :systemDate ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findValidTemporarily(@Param("systemDate") String systemDate, Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.validUntil IS NULL ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findValidPermanently(Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.unconfirmedEmail = '1' ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findNotYetConfirmedEmail(Pageable page);

  @Query("SELECT ua FROM UserAccount ua WHERE ua.imported = '1' ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findImported(Pageable page);

  @Modifying
  @Query("UPDATE UserAccount ua SET ua.imported = '' WHERE ua.imported != ''")
  public void resetImported();

  @Query("SELECT ua FROM UserAccount ua WHERE DATE(ua.creationDatetime) >= :fromDate AND DATE(ua.creationDatetime) <= :toDate ORDER BY ua.lastname, ua.firstname")
  public Page<UserAccount> findByCreationDatetime(@Param("fromDate") String fromDate, @Param("toDate") String toDate, Pageable page);

}
