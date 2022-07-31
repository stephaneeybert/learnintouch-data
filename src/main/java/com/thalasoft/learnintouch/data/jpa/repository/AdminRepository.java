package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;

public interface AdminRepository extends GenericRepository<Admin, Long>, AdminRepositoryCustom {

	public Admin findByEmail(String email);
	
	public Admin findByLogin(String login);

	public Admin findByLoginAndPassword(String login, String password);
	
	@Query("SELECT a FROM Admin a WHERE LOWER(a.firstname) LIKE LOWER(CONCAT(:searchTerm, '%')) OR LOWER(a.lastname) LIKE LOWER(CONCAT(:searchTerm, '%')) ORDER BY a.lastname, a.firstname ASC")
	public Page<Admin> findByFirstnameStartingWithOrLastnameStartingWith(@Param("searchTerm") String searchTerm, Pageable page);

	@Query("SELECT a FROM Admin a ORDER BY a.lastname, a.firstname ASC")
	public Page<Admin> all(Pageable page);
	
    @Query("SELECT a FROM Admin a WHERE LOWER(a.firstname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(a.lastname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(a.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(a.login) LIKE LOWER(CONCAT('%', :searchTerm, '%')) ORDER BY a.lastname ASC, a.firstname ASC")
	public Page<Admin> search(@Param("searchTerm") String searchTerm, Pageable page);
	
	@Query("SELECT a FROM Admin a WHERE a.superAdmin != '1' OR a.login = :login ORDER BY a.lastname, a.firstname ASC")
    public Page<Admin> findAllNonSuperAdminPlusOneWithLogin(@Param("login") String login, Pageable pageable);

	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Query("UPDATE Admin SET firstname = :firstname, lastname = :lastname, login = :login, superAdmin = :superAdmin, preferenceAdmin = :preferenceAdmin, address =  :address, zipCode = :zipCode, city = :city, country = :country, email = :email, profile = :profile, postLoginUrl = :postLoginUrl WHERE id = :id")
	public void update(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("login") String login, @Param("superAdmin") boolean superAdmin, @Param("preferenceAdmin") boolean preferenceAdmin, @Param("address") String address, @Param("zipCode") String zipCode, @Param("city") String city, @Param("country") String country, @Param("email") String email, @Param("profile") String profile, @Param("postLoginUrl") String postLoginUrl, @Param("id") Long id);

	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Query("UPDATE Admin SET password = :password, passwordSalt = :passwordSalt WHERE id = :id")
	public void updatePassword(@Param("password") String password, @Param("passwordSalt") String passwordSalt, @Param("id") Long id);
	
}
