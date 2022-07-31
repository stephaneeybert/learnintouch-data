package com.thalasoft.learnintouch.data.service.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityAlreadyExistsException;
import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.UserRole;

@Transactional
public interface UserRoleService {

	public UserRole add(UserRole userRole) throws EntityAlreadyExistsException;
	
	public UserRole update(Long id, UserRole userRole) throws EntityNotFoundException;
	
	public UserRole delete(Long id) throws EntityNotFoundException;
	
	public UserRole findById(Long id) throws EntityNotFoundException;
	
	public void deleteByUserAccount(Long userId);

	public UserRole findByUserAccountAndRole(Long userId, String role);

	public List<UserRole> findByUserAccount(Long userId);

}
