package com.thalasoft.learnintouch.data.jpa.repository;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.UserRole;

public interface UserRoleRepositoryCustom {

	public UserRole deleteByUserRoleId(Long id) throws EntityNotFoundException;

}
