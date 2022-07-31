package com.thalasoft.learnintouch.data.service.jpa;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityAlreadyExistsException;
import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.domain.AdminModule;
import com.thalasoft.learnintouch.data.jpa.repository.AdminModuleRepository;
import com.thalasoft.learnintouch.data.jpa.repository.AdminRepository;

@Service
public class AdminModuleServiceImpl implements AdminModuleService {

	@Resource
	private AdminModuleRepository adminModuleRepository;

	@Resource
	private AdminRepository adminRepository;

	@Override
	public Page<AdminModule> findAll(Pageable page) {
		return adminModuleRepository.findAll(page);
	}

	@Override
	public AdminModule findById(Long id) {
		return adminModuleRepository.findOne(id);
	}

	@Override
	public AdminModule findByAdminAndModule(Admin admin, String module) {
		return adminModuleRepository.findByAdminAndModule(admin, module);
	}

	@Modifying
	@Transactional(rollbackFor = EntityAlreadyExistsException.class)
	@Override
	public AdminModule add(AdminModule adminModule) throws EntityAlreadyExistsException {
        if (findByAdminAndModule(adminModule.getAdmin(), adminModule.getModule()) == null) {
        	// Save the returned id into the entity
        	adminModule = adminModuleRepository.saveAndFlush(adminModule);
        	return adminModule;
        } else {
        	throw new EntityAlreadyExistsException(adminModule.getModule());
        }
	}
	
	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Override
	public AdminModule update(AdminModule adminModule) throws EntityNotFoundException {
		AdminModule foundAdminModule = findById(adminModule.getId());
        if (foundAdminModule == null) {
        	throw new EntityNotFoundException();
        } else {
        	BeanUtils.copyProperties(adminModule, foundAdminModule);
        	return foundAdminModule;
        }
	}

	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Override
	public AdminModule deleteById(Long id) throws EntityNotFoundException {
		AdminModule adminModule = findById(id);
        if (adminModule == null) {
        	throw new EntityNotFoundException();
        } else {
    		adminModuleRepository.delete(adminModule);
    		return adminModule;
        }
	}

}
