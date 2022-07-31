package com.thalasoft.learnintouch.data.jpa.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import com.thalasoft.learnintouch.data.jpa.domain.AbstractEntity;
import com.thalasoft.learnintouch.data.jpa.domain.Admin;

public class AdminAssert extends AbstractAssert<AdminAssert, Admin> {

	private AdminAssert(Admin actual) {
		super(actual, AdminAssert.class);
	}
	
	public static AdminAssert assertThatAdmin(Admin actual) {
		return new AdminAssert(actual);
	}

	public AdminAssert hasId(Long id) {
		isNotNull();
		assertThat(actual.getId()).overridingErrorMessage("Expected the id to be <%s> but was <%s>.", id, actual.getId()).isEqualTo(id);
		return this;
	}

	public AdminAssert hasAnIdNotNull() {
		isNotNull();
		assertThat(actual.getId()).overridingErrorMessage("Expected the id to be not null but was null.").isNotNull();
		return this;
	}

	public AdminAssert hasEmail(String email) {
		isNotNull();
		assertThat(actual.getEmail()).overridingErrorMessage("Expected the email to be <%s> but was <%s>.", email, actual.getEmail()).isEqualTo(email);
		return this;
	}
	
	public AdminAssert hasLogin(String login) {
		isNotNull();
		assertThat(actual.getLogin()).overridingErrorMessage("Expected the login to be <%s> but was <%s>.", login, actual.getLogin()).isEqualTo(login);
		return this;
	}
	
	public AdminAssert hasPassword(String password) {
		isNotNull();
		assertThat(actual.getPassword()).overridingErrorMessage("Expected the password to be <%s> but was <%s>.", password, actual.getPassword()).isEqualTo(password);
		return this;
	}
	
	public AdminAssert isSameAs(AbstractEntity entity) {
		isNotNull();
		assertThat(actual.hashCode()).overridingErrorMessage("Expected the hash code to be <%s> but was <%s>.", entity.hashCode(), actual.hashCode()).isEqualTo(entity.hashCode());
		return this;
	}
	
	public AdminAssert exists() {
		assertThat(actual).overridingErrorMessage("Expected the admin to exist but it didn't.").isNotNull();
		return this;
	}
	
	public AdminAssert doesNotExist() {
		assertThat(actual).overridingErrorMessage("Expected the admin not to exist but it did.").isNull();
		return this;
	}
	
	public AdminAssert exist() {
		assertThat(actual).overridingErrorMessage("Expected the admin to exist but it did not.").isNotNull();
		return this;
	}

}
