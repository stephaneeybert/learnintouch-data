package com.thalasoft.learnintouch.data.service.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.service.event.admin.CreateAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.CreatedAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.DeleteAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.DeletedAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.GetOneAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.GotOneAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.SearchAdminsEvent;
import com.thalasoft.learnintouch.data.service.event.admin.SearchedAdminsEvent;
import com.thalasoft.learnintouch.data.service.event.admin.UpdateAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.UpdatedAdminEvent;

@Transactional
public interface AdminService {

	public Page<Admin> all(Pageable page);
	
	public Page<Admin> searchOnName(String searchTerm, Pageable page);
	
	public Page<Admin> search(String searchTerm, Pageable page);
	
	public SearchedAdminsEvent search(SearchAdminsEvent searchAdminEvent);
	
	public Admin findByLogin(String login);
	
	public Admin findByLoginAndPassword(String login, String password);
	
	public Admin findByEmail(String email);

	public Admin findById(Long id);
    
	public GotOneAdminEvent findById(GetOneAdminEvent getOneAdminEvent);
	
	public Admin add(Admin admin) throws EntityNotFoundException;

	public CreatedAdminEvent add(CreateAdminEvent createAdminEvent) throws EntityNotFoundException;
	
	public Admin update(Admin admin) throws EntityNotFoundException;
	
	public UpdatedAdminEvent update(UpdateAdminEvent updateAdminEvent) throws EntityNotFoundException;

	public Admin delete(Long id) throws EntityNotFoundException;
	
    public DeletedAdminEvent deleteById(DeleteAdminEvent deleteAdminEvent) throws EntityNotFoundException;
    
	public Admin savePassword(Admin admin, String password);
	
	public boolean checkPassword(Admin admin, String password);
	
}
