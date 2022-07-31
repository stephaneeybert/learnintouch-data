package com.thalasoft.learnintouch.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;
import com.thalasoft.learnintouch.data.jpa.domain.UserRole;

public interface UserRoleRepository extends GenericRepository<UserRole, Long>, UserRoleRepositoryCustom {

	public UserRole findByUserAccountAndRole(UserAccount userAccount, String role);
	
	@Query("SELECT ur FROM UserRole ur WHERE ur.userAccount = :userAccount ORDER BY ur.role")
	public List<UserRole> findByUserAccount(@Param("userAccount") UserAccount userAccount);

	@Modifying
	@Query("DELETE FROM UserRole ur WHERE ur.userAccount = :userAccount")
	public void deleteByUserAccount(@Param("userAccount") UserAccount userAccount);

}
