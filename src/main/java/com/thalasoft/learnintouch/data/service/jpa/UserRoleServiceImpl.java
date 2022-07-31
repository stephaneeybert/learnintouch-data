package com.thalasoft.learnintouch.data.service.jpa;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityAlreadyExistsException;
import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;
import com.thalasoft.learnintouch.data.jpa.domain.UserRole;
import com.thalasoft.learnintouch.data.jpa.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {

  @Resource
  UserAccountService userService;

  @Resource
  private UserRoleRepository userRoleRepository;

  @Override
  public UserRole findById(Long id) {
    return userRoleRepository.findOne(id);
  }

  @Modifying
  @Transactional(rollbackFor = EntityAlreadyExistsException.class)
  @Override
  public UserRole add(UserRole userRole) throws EntityAlreadyExistsException {
    if (findByUserAccountAndRole(userRole.getUserAccount().getId(), userRole.getRole()) == null) {
      // Save the returned id into the entity
      userRole = userRoleRepository.saveAndFlush(userRole);
      return userRole;
    } else {
      throw new EntityAlreadyExistsException();
    }
  }

  @Modifying
  @Transactional(rollbackFor = EntityNotFoundException.class)
  @Override
  public UserRole update(Long id, UserRole userRole) throws EntityNotFoundException {
    UserRole foundUserRole = findById(id);
    if (foundUserRole == null) {
      throw new EntityNotFoundException();
    } else {
      BeanUtils.copyProperties(userRole, foundUserRole);
      return foundUserRole;
    }
  }

  @Modifying
  @Transactional(rollbackFor = EntityNotFoundException.class)
  @Override
  public UserRole delete(Long id) throws EntityNotFoundException {
    UserRole userRole = findById(id);
    if (userRole == null) {
      throw new EntityNotFoundException();
    } else {
      userRoleRepository.delete(userRole);
      return userRole;
    }
  }

  public UserRole findByUserAccountAndRole(Long userId, String role) {
    UserAccount userAccount = userService.findById(userId);
    if (userAccount != null) {
      return userRoleRepository.findByUserAccountAndRole(userAccount, role);
    } else {
      return null;
    }
  }

  public List<UserRole> findByUserAccount(Long userId) {
    UserAccount userAccount = userService.findById(userId);
    if (userAccount != null) {
      return userRoleRepository.findByUserAccount(userAccount);
    } else {
      return null;
    }
  }

  public void deleteByUserAccount(Long userId) {
    UserAccount userAccount = userService.findById(userId);
    if (userAccount != null) {
      userRoleRepository.deleteByUserAccount(userAccount);
    }
  }

}
