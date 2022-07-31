package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.domain.AdminOption;

public interface AdminOptionRepository extends GenericRepository<AdminOption, Long> {

	@Query("SELECT a FROM AdminOption a ORDER BY a.name")
	public Page<AdminOption> findThemAll(Pageable page);

	@Query("SELECT a FROM AdminOption a WHERE a.admin = :admin ORDER BY a.name")
	public Page<AdminOption> findByAdmin(@Param("admin") Admin admin, Pageable page);

	public AdminOption findByAdminAndName(Admin admin, String name);
	
	public Page<AdminOption> findByName(String name, Pageable page);

}
