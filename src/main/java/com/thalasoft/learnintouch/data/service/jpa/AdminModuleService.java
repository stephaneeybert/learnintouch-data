package com.thalasoft.learnintouch.data.service.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.domain.AdminModule;

@Transactional
public interface AdminModuleService {

	public Page<AdminModule> findAll(Pageable page);
	
    public AdminModule findById(Long id);
    
    public AdminModule findByAdminAndModule(Admin admin, String module);
    
	public AdminModule add(AdminModule adminModule);
	
	public AdminModule update(AdminModule adminModule) throws EntityNotFoundException;
	
	public AdminModule deleteById(Long id) throws EntityNotFoundException;
	
}
