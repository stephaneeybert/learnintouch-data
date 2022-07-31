package com.thalasoft.learnintouch.data.jpa.repository;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;

public interface AdminRepositoryCustom {

	public Admin deleteByAdminId(Long id) throws EntityNotFoundException;

}
