package com.thalasoft.learnintouch.data.service.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityAlreadyExistsException;
import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.EmailAddress;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

@Transactional
public interface UserAccountService {

  public UserAccount add(UserAccount userAccount) throws EntityAlreadyExistsException;

  public UserAccount update(Long id, UserAccount userAccount) throws EntityNotFoundException;

  public UserAccount delete(Long id) throws EntityNotFoundException;

  public UserAccount findById(Long id);

  public Page<UserAccount> all(Pageable page);

  public UserAccount findByEmailAndPassword(EmailAddress email, String password);

  public UserAccount findByEmail(String email);

  public Page<UserAccount> findByUnconfirmedEmailIsTrue(Pageable page);

  public Page<UserAccount> findByUnconfirmedEmailIsFalse(Pageable page);

  public Page<UserAccount> searchOnName(String searchTerm, Pageable page);

  public Page<UserAccount> search(String searchTerm, Pageable page);

  public void clearReadablePassword(UserAccount userAccount);

}
