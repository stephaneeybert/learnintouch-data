package com.thalasoft.learnintouch.data.service.event.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.thalasoft.learnintouch.data.jpa.domain.Admin;

public class EventAdmin {

    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String passwordSalt;
    private boolean superAdmin;
    private boolean preferenceAdmin;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private String email;
    private String profile;
    private String postLoginUrl;

    public EventAdmin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public boolean getSuperAdmin() {
        return this.superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public boolean getPreferenceAdmin() {
        return this.preferenceAdmin;
    }

    public void setPreferenceAdmin(boolean preferenceAdmin) {
        this.preferenceAdmin = preferenceAdmin;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPostLoginUrl() {
        return postLoginUrl;
    }

    public void setPostLoginUrl(String postLoginUrl) {
        this.postLoginUrl = postLoginUrl;
    }

    public static EventAdmin newFrom(Admin admin) {
        EventAdmin eventAdmin = null;

        if (admin != null) {
            eventAdmin = new EventAdmin();
            BeanUtils.copyProperties(admin, eventAdmin);
        }
        
        return eventAdmin;
    }

    public static Admin newFrom(EventAdmin eventAdmin) {
    	Admin admin = null;
    	if (eventAdmin != null) {
    		Admin.AdminBuilder adminBuilder = new Admin.AdminBuilder(eventAdmin.getId());
        	admin = adminBuilder
        	.setFirstname(eventAdmin.getFirstname())
        	.setLastname(eventAdmin.getLastname())
        	.setEmail(eventAdmin.getEmail())
        	.setLogin(eventAdmin.getLogin())
        	.setPassword(eventAdmin.getPassword())
        	.setPasswordSalt(eventAdmin.getPasswordSalt())
        	.setSuperAdmin(eventAdmin.getSuperAdmin())
        	.setPreferenceAdmin(eventAdmin.getPreferenceAdmin())
        	.setAddress(eventAdmin.getAddress())
        	.setZipCode(eventAdmin.getZipCode())
        	.setCity(eventAdmin.getCity())
        	.setCountry(eventAdmin.getCountry())
        	.setProfile(eventAdmin.getProfile())
        	.setPostLoginUrl(eventAdmin.getPostLoginUrl())
        	.build();
    	}
    	return admin;
    }
    
    public static List<EventAdmin> newEventAdminsFrom(List<Admin> admins) {
    	List<EventAdmin> eventAdmins = new ArrayList<EventAdmin>(); 
		for (Admin admin : admins) {
			EventAdmin eventAdmin = EventAdmin.newFrom(admin);
			eventAdmins.add(eventAdmin);
		}
		return eventAdmins;
    }
    
    public static List<Admin> newAdminsFrom(List<EventAdmin> eventAdmins) {
    	List<Admin> admins = new ArrayList<Admin>(); 
		for (EventAdmin eventAdmin : eventAdmins) {
			Admin admin = EventAdmin.newFrom(eventAdmin);
			admins.add(admin);
		}
		return admins;
    }
    
}
