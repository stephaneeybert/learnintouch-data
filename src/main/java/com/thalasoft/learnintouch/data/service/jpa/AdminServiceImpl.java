package com.thalasoft.learnintouch.data.service.jpa;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.AdminAlreadyExistsException;
import com.thalasoft.learnintouch.data.exception.EntityAlreadyExistsException;
import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.repository.AdminRepository;
import com.thalasoft.learnintouch.data.service.event.admin.CreateAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.CreatedAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.DeleteAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.DeletedAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.EventAdmin;
import com.thalasoft.learnintouch.data.service.event.admin.GetOneAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.GotOneAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.SearchAdminsEvent;
import com.thalasoft.learnintouch.data.service.event.admin.SearchedAdminsEvent;
import com.thalasoft.learnintouch.data.service.event.admin.UpdateAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.UpdatedAdminEvent;
import com.thalasoft.learnintouch.data.utils.Common;

@Service
public class AdminServiceImpl implements AdminService {

    private final int ADMIN_PASSWORD_SALT_LENGTH = 30;

	@Resource
	private AdminRepository adminRepository;

	@Override
	public Page<Admin> search(String searchTerm, Pageable page) {
		return adminRepository.search(searchTerm, page);
	}

	@Override
	public Page<Admin> all(Pageable page) {
		return adminRepository.all(page);
	}
	
	@Override
	public SearchedAdminsEvent search(SearchAdminsEvent searchAdminsEvent) {
		Page<Admin> admins = adminRepository.search(searchAdminsEvent.getSearchTerm(), searchAdminsEvent.getPageRequest());
		List<EventAdmin> eventAdmins = EventAdmin.newEventAdminsFrom(admins.getContent());
		return new SearchedAdminsEvent(searchAdminsEvent.getSearchTerm(), searchAdminsEvent.getPageRequest(), eventAdmins, admins.getTotalPages(), admins.getTotalElements());
	}

	@Override
	public Page<Admin> searchOnName(String searchTerm, Pageable page) {
		return adminRepository.findByFirstnameStartingWithOrLastnameStartingWith(searchTerm, page);
	}
	
	@Override
	public Admin findByLogin(String login) {
		return adminRepository.findByLogin(login);
	}
	
	@Override
	public Admin findByLoginAndPassword(String login, String password) {
		return adminRepository.findByLoginAndPassword(login, password);
	}
	
	@Override
	public Admin findById(Long id) {
	    return adminRepository.findOne(id);
	}

	@Override
	public Admin findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}
	
	@Override
	public GotOneAdminEvent findById(GetOneAdminEvent getOneAdminEvent) throws EntityNotFoundException {
       	Admin admin = adminRepository.findOne(getOneAdminEvent.getId());
       	GotOneAdminEvent oneAdminEvent = null;
       	if (admin != null) {
       	  oneAdminEvent = new GotOneAdminEvent(EventAdmin.newFrom(admin));
       	}
        return oneAdminEvent;
	}
	
	@Modifying
	@Transactional(rollbackFor = EntityAlreadyExistsException.class)
	@Override
	public Admin add(Admin admin) throws EntityAlreadyExistsException {
        if (findByLogin(admin.getLogin()) == null) {
        	// Save the returned id into the entity
        	admin = adminRepository.saveAndFlush(admin);
        	return admin;
        } else {
        	throw new EntityAlreadyExistsException();
        }
	}
	
	@Modifying
	@Transactional(rollbackFor = AdminAlreadyExistsException.class)
	@Override
	public CreatedAdminEvent add(CreateAdminEvent createAdminEvent) throws AdminAlreadyExistsException {
	    Admin admin = EventAdmin.newFrom(createAdminEvent.getEventAdmin());
        if (findByLogin(admin.getLogin()) == null) {
        	// Save the returned id into the entity
        	admin = adminRepository.saveAndFlush(admin);
        	return new CreatedAdminEvent(admin.getId(), EventAdmin.newFrom(admin));
        } else {
        	throw new AdminAlreadyExistsException(admin.getEmail());
        }
	}
	
	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Override
	public Admin update(Admin admin) throws EntityNotFoundException {
		Admin foundAdmin = findById(admin.getId());
        if (foundAdmin == null) {
        	throw new EntityNotFoundException();
        } else {
        	BeanUtils.copyProperties(admin, foundAdmin);
            return foundAdmin;
        }
	}

    @Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
    @Override
    public UpdatedAdminEvent update(UpdateAdminEvent updateAdminEvent) throws EntityNotFoundException {
        Admin admin  = adminRepository.findOne(updateAdminEvent.getEventAdmin().getId());
        if (admin == null) {
        	throw new EntityNotFoundException();
        } else {
        	admin = EventAdmin.newFrom(updateAdminEvent.getEventAdmin());
        	// Save the returned id into the entity
            admin = adminRepository.saveAndFlush(admin);
            EventAdmin eventAdmin = EventAdmin.newFrom(admin);
            return new UpdatedAdminEvent(eventAdmin.getId(), eventAdmin);
        }
    }

	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Override
	public Admin delete(Long id) throws EntityNotFoundException {
		Admin admin = findById(id);
        if (admin == null) {
        	throw new EntityNotFoundException();
        } else {
    		adminRepository.delete(admin);
    		return admin;
        }
	}

    @Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
    @Override
    public DeletedAdminEvent deleteById(DeleteAdminEvent deleteAdminEvent) throws EntityNotFoundException {
        Admin admin  = adminRepository.findOne(deleteAdminEvent.getId());            
        if (admin == null) {
        	throw new EntityNotFoundException();
        } else {
            adminRepository.delete(admin);
            EventAdmin eventAdmin = EventAdmin.newFrom(admin);
            return new DeletedAdminEvent(eventAdmin.getId(), eventAdmin);
        }
    }

    @Override
    public Admin savePassword(Admin admin, String password) {
        String salt = generatePasswordSalt();
    	Admin updatedAdmin = new Admin.AdminBuilder(admin)
    	.setPassword(saltAndHashPassword(password, admin.getPasswordSalt()))
    	.setPasswordSalt(salt)
        .build();
    	// Save the returned id into the entity
    	updatedAdmin = adminRepository.saveAndFlush(updatedAdmin);
    	return updatedAdmin;
    }

    @Override
    public boolean checkPassword(Admin admin, String password) {
        return admin.getPassword().equals(saltAndHashPassword(password, admin.getPasswordSalt()));
    }
    
    private String saltAndHashPassword(String password, String salt) {
        return Common.phpCompatibleMD5(saltPassword(password, salt));
    }
    
    private String generatePasswordSalt() {
        return Common.generateUniqueId(ADMIN_PASSWORD_SALT_LENGTH);
    }
    
    private String saltPassword(String password, String salt) {
        return password + salt;
    }

}
