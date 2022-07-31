package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;

public class AdminRepositoryImpl implements AdminRepositoryCustom {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	@Transactional
	public Admin deleteByAdminId(Long id) throws EntityNotFoundException {
		Admin entity = adminRepository.findOne(id);
		if (entity != null) {
			adminRepository.delete(entity);
		} else {
			throw new EntityNotFoundException();
		}
		return entity;
	}
	
}
