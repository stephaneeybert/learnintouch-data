package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.BeanUtils;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_admin")
public class Admin extends AbstractEntity {

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique = true, length = 50)
    private String login;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String passwordSalt;
    @Column(nullable = false)
    private boolean superAdmin;
    @Column(nullable = false)
    private boolean preferenceAdmin;
    private String address;
    @Column(length = 10)
    private String zipCode;
    private String city;
    private String country;
    @Column(nullable = false)
    private String email;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String profile;
    private String postLoginUrl;

    private Admin() {
    }

    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
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

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	public boolean isPreferenceAdmin() {
		return preferenceAdmin;
	}

	public void setPreferenceAdmin(boolean preferenceAdmin) {
		this.preferenceAdmin = preferenceAdmin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
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

	public static class AdminBuilder {

    	Admin admin;

    	public AdminBuilder() {
    		admin = new Admin();
    	}
    	
    	public AdminBuilder(String firstname, String lastname, String email, String login) {
    		admin = new Admin();
    		admin.firstname = firstname;
    		admin.lastname = lastname;
    		admin.email = email;
    		admin.login = login;
    	}
    	
    	public AdminBuilder(String email, String login) {
    		admin = new Admin();
    		admin.email = email;
    		admin.login = login;
    	}
    	
    	public AdminBuilder(Long id) {
    		admin = new Admin();
    		admin.setId(id);
    	}
    	
    	public AdminBuilder(Admin copy) {
    		admin = new Admin();
    		BeanUtils.copyProperties(copy, admin);
    	}
    	
    	public AdminBuilder setFirstname(String firstname) {
    		admin.firstname = firstname;
    		return this;
    	}
    	
    	public AdminBuilder setLastname(String lastname) {
    		admin.lastname = lastname;
    		return this;
    	}
    	
    	public AdminBuilder setLogin(String login) {
    		admin.login = login;
    		return this;
    	}
    	
    	public AdminBuilder setPassword(String password) {
    		admin.password = password;
    		return this;
    	}
    	
    	public AdminBuilder setPasswordSalt(String passwordSalt) {
    		admin.passwordSalt = passwordSalt;
    		return this;
    	}

        public AdminBuilder setSuperAdmin(boolean superAdmin) {
            admin.superAdmin = superAdmin;
    		return this;
        }

        public AdminBuilder setPreferenceAdmin(boolean preferenceAdmin) {
            admin.preferenceAdmin = preferenceAdmin;
            return this;
        }

        public AdminBuilder setAddress(String address) {
            admin.address = address;
            return this;
        }

        public AdminBuilder setZipCode(String zipCode) {
            admin.zipCode = zipCode;
            return this;
        }

        public AdminBuilder setCity(String city) {
            admin.city = city;
            return this;
        }

        public AdminBuilder setCountry(String country) {
            admin.country = country;
            return this;
        }

        public AdminBuilder setEmail(String email) {
            admin.email = email;
            return this;
        }

        public AdminBuilder setProfile(String profile) {
            admin.profile = profile;
            return this;
        }

        public AdminBuilder setPostLoginUrl(String postLoginUrl) {
            admin.postLoginUrl = postLoginUrl;
            return this;
        }

    	public Admin build() {
    		return admin;
    	}
    	
    }

}
