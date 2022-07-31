package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.UserRole;

public class UserRoleRepositoryImpl implements UserRoleRepositoryCustom {

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	@Transactional
	public UserRole deleteByUserRoleId(Long id) throws EntityNotFoundException {
		UserRole entity = userRoleRepository.findOne(id);
		if (entity != null) {
		  userRoleRepository.delete(entity);
		} else {
			throw new EntityNotFoundException("The user role entity could not be found and was not deleted");
		}
		return entity;
	}
	
}
