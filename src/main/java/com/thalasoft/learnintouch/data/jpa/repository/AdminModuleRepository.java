package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.domain.AdminModule;

public interface AdminModuleRepository extends GenericRepository<AdminModule, Long> {

	@Query("SELECT a FROM AdminModule a ORDER BY a.module")
	public Page<AdminModule> findThemAll(Pageable page);

	@Query("SELECT a FROM AdminModule a WHERE a.admin = :admin ORDER BY a.module")
	public Page<AdminModule> findByAdmin(@Param("admin") Admin admin, Pageable page);
	
	public AdminModule findByAdminAndModule(Admin admin, String module);
	
	public Page<AdminModule> findByModule(String module, Pageable page);

}
