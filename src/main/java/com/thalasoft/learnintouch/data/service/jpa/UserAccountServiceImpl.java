package com.thalasoft.learnintouch.data.service.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityAlreadyExistsException;
import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.EmailAddress;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;
import com.thalasoft.learnintouch.data.jpa.domain.UserRole;
import com.thalasoft.learnintouch.data.jpa.repository.UserAccountRepository;
import com.thalasoft.learnintouch.data.jpa.repository.UserRoleRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

  @Resource
  private UserAccountRepository userAccountRepository;

  @Resource
  private UserRoleRepository userRoleRepository;

  @Override
  public Page<UserAccount> all(Pageable page) {
    return userAccountRepository.all(page);
  }

  @Override
  public Page<UserAccount> search(String searchTerm, Pageable page) {
    return userAccountRepository.search(searchTerm, page);
  }

  @Override
  public Page<UserAccount> searchOnName(String searchTerm, Pageable page) {
    return userAccountRepository.searchOnName(searchTerm, page);
  }

  @Override
  public UserAccount findByEmail(String email) {
    return userAccountRepository.findByEmail(new EmailAddress(email));
  }

  @Override
  public UserAccount findByEmailAndPassword(EmailAddress email, String password) {
    return userAccountRepository.findByEmailAndPassword(email, password);
  }

  @Override
  public Page<UserAccount> findByUnconfirmedEmailIsTrue(Pageable page) {
    return userAccountRepository.findByUnconfirmedEmailIsTrue(page);
  }

  @Override
  public Page<UserAccount> findByUnconfirmedEmailIsFalse(Pageable page) {
    return userAccountRepository.findByUnconfirmedEmailIsFalse(page);
  }

  @Override
  public UserAccount findById(Long id) {
    return userAccountRepository.findOne(id);
  }

  @Modifying
  @Transactional(rollbackFor = EntityAlreadyExistsException.class)
  @Override
  public UserAccount add(UserAccount userAccount) throws EntityAlreadyExistsException {
    if (findByEmail(userAccount.getEmail().toString()) == null) {
      Set<UserRole> userRoles = new HashSet<UserRole>();
      for (UserRole userRole : userAccount.getUserRoles()) {
        userRole.setUserAccount(userAccount);
        userRoles.add(userRole);
      }
      userAccount.setUserRoles(userRoles);
      // Save the returned id into the entity
      userAccount = userAccountRepository.saveAndFlush(userAccount);
      return userAccount;
    } else {
      throw new EntityAlreadyExistsException();
    }
  }

  @Modifying
  @Transactional(rollbackFor = EntityNotFoundException.class)
  @Override
  public UserAccount update(Long id, UserAccount userAccount) throws EntityNotFoundException {
    UserAccount foundUserAccount = findById(id);
    if (foundUserAccount == null) {
      throw new EntityNotFoundException();
    } else {
      Set<UserRole> userRoles = new HashSet<UserRole>();
      for (UserRole userRole : userAccount.getUserRoles()) {
        userRole.setUserAccount(userAccount);
        userRoles.add(userRole);
      }
      userAccount.setUserRoles(userRoles);
      // Save the returned id into the entity
      foundUserAccount = userAccountRepository.saveAndFlush(userAccount);
      return foundUserAccount;
    }
  }

  @Modifying
  @Transactional(rollbackFor = EntityNotFoundException.class)
  @Override
  public UserAccount delete(Long id) throws EntityNotFoundException {
    UserAccount userAccount = findById(id);
    if (userAccount == null) {
      throw new EntityNotFoundException();
    } else {
//      userRoleRepository.deleteByUser(userAccount);
      userAccountRepository.delete(userAccount);
      return userAccount;
    }
  }

  @Modifying
  @Transactional(rollbackFor = EntityNotFoundException.class)
  @Override
  public void clearReadablePassword(UserAccount userAccount) throws EntityNotFoundException {
    UserAccount foundUserAccount = findById(userAccount.getId());
    if (foundUserAccount == null) {
      throw new EntityNotFoundException();
    } else {
      foundUserAccount.setReadablePassword(null);
    }
  }

}
