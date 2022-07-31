package com.thalasoft.learnintouch.data.jpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.thalasoft.learnintouch.data.jpa.domain.QUserAccount;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

public class UserAccountRepositoryImpl implements UserAccountRepositoryCustom {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<UserAccount> search(String searchTerm, Pageable page) {
    	JPAQuery query = new JPAQuery(userAccountRepository.getEntityManager());
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.or(qUserAccount.id.like(searchTerm)).or(qUserAccount.firstname.contains(searchTerm)).or(qUserAccount.lastname.contains(searchTerm)).or(qUserAccount.email.value.contains(searchTerm)).or(qUserAccount.organisation.contains(searchTerm)).or(qUserAccount.homePhone.contains(searchTerm)).or(qUserAccount.workPhone.contains(searchTerm)).or(qUserAccount.mobilePhone.contains(searchTerm)).or(qUserAccount.fax.contains(searchTerm));
		if (searchTerm.contains(" ")) {
			String[] bits = searchTerm.split(" ");
			String firstname = bits[0];
			String lastname = bits[1];
			builder.or(qUserAccount.firstname.contains(firstname).and(qUserAccount.lastname.contains(lastname)));
		}
		query.where(builder);
		query.orderBy(qUserAccount.lastname.asc(), qUserAccount.firstname.asc());
		List<UserAccount> resultList = query.list(qUserAccount);
        long total = resultList.size();        
        query.offset(page.getOffset());
        query.limit(page.getPageSize());
        resultList = query.list(qUserAccount);
        Page<UserAccount> useerAccounts = new PageImpl<UserAccount>(resultList, page, total);
        return useerAccounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserAccount> searchMailSubscribers(String searchTerm, Pageable page) {
    	JPAQuery query = new JPAQuery(userAccountRepository.getEntityManager());
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qUserAccount.mailSubscribe.isTrue()).and(qUserAccount.id.like(searchTerm).or(qUserAccount.firstname.contains(searchTerm)).or(qUserAccount.lastname.contains(searchTerm)).or(qUserAccount.email.value.contains(searchTerm)).or(qUserAccount.organisation.contains(searchTerm)).or(qUserAccount.homePhone.contains(searchTerm)).or(qUserAccount.workPhone.contains(searchTerm)).or(qUserAccount.mobilePhone.contains(searchTerm)).or(qUserAccount.fax.contains(searchTerm)));
		if (searchTerm.contains(" ")) {
			String[] bits = searchTerm.split(" ");
			String firstname = bits[0];
			String lastname = bits[1];
			builder.or(qUserAccount.firstname.contains(firstname).and(qUserAccount.lastname.contains(lastname)));
		}
		query.where(builder);
		query.orderBy(qUserAccount.lastname.asc(), qUserAccount.firstname.asc());
		List<UserAccount> resultList = query.list(qUserAccount);
        long total = resultList.size();        
        query.offset(page.getOffset());
        query.limit(page.getPageSize());
        resultList = query.list(qUserAccount);
        Page<UserAccount> useerAccounts = new PageImpl<UserAccount>(resultList, page, total);
        return useerAccounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserAccount> searchNotMailSubscribers(String searchTerm, Pageable page) {
    	JPAQuery query = new JPAQuery(userAccountRepository.getEntityManager());
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qUserAccount.mailSubscribe.isFalse()).and(qUserAccount.id.like(searchTerm).or(qUserAccount.firstname.contains(searchTerm)).or(qUserAccount.lastname.contains(searchTerm)).or(qUserAccount.email.value.contains(searchTerm)).or(qUserAccount.organisation.contains(searchTerm)).or(qUserAccount.homePhone.contains(searchTerm)).or(qUserAccount.workPhone.contains(searchTerm)).or(qUserAccount.mobilePhone.contains(searchTerm)).or(qUserAccount.fax.contains(searchTerm)));
		if (searchTerm.contains(" ")) {
			String[] bits = searchTerm.split(" ");
			String firstname = bits[0];
			String lastname = bits[1];
			builder.or(qUserAccount.firstname.contains(firstname).and(qUserAccount.lastname.contains(lastname)));
		}
		query.where(builder);
		query.orderBy(qUserAccount.lastname.asc(), qUserAccount.firstname.asc());
		List<UserAccount> resultList = query.list(qUserAccount);
        long total = resultList.size();        
        query.offset(page.getOffset());
        query.limit(page.getPageSize());
        resultList = query.list(qUserAccount);
        Page<UserAccount> useerAccounts = new PageImpl<UserAccount>(resultList, page, total);
        return useerAccounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserAccount> searchSmsSubscribers(String searchTerm, Pageable page) {
    	JPAQuery query = new JPAQuery(userAccountRepository.getEntityManager());
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qUserAccount.smsSubscribe.isTrue()).and(qUserAccount.id.like(searchTerm).or(qUserAccount.firstname.contains(searchTerm)).or(qUserAccount.lastname.contains(searchTerm)).or(qUserAccount.email.value.contains(searchTerm)).or(qUserAccount.organisation.contains(searchTerm)).or(qUserAccount.homePhone.contains(searchTerm)).or(qUserAccount.workPhone.contains(searchTerm)).or(qUserAccount.mobilePhone.contains(searchTerm)).or(qUserAccount.fax.contains(searchTerm)));
		if (searchTerm.contains(" ")) {
			String[] bits = searchTerm.split(" ");
			String firstname = bits[0];
			String lastname = bits[1];
			builder.or(qUserAccount.firstname.contains(firstname).and(qUserAccount.lastname.contains(lastname)));
		}
		query.where(builder);
		query.orderBy(qUserAccount.lastname.asc(), qUserAccount.firstname.asc());
		List<UserAccount> resultList = query.list(qUserAccount);
        long total = resultList.size();        
        query.offset(page.getOffset());
        query.limit(page.getPageSize());
        resultList = query.list(qUserAccount);
        Page<UserAccount> useerAccounts = new PageImpl<UserAccount>(resultList, page, total);
        return useerAccounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserAccount> searchNotSmsSubscribers(String searchTerm, Pageable page) {
    	JPAQuery query = new JPAQuery(userAccountRepository.getEntityManager());
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qUserAccount.smsSubscribe.isFalse()).and(qUserAccount.id.like(searchTerm).or(qUserAccount.firstname.contains(searchTerm)).or(qUserAccount.lastname.contains(searchTerm)).or(qUserAccount.email.value.contains(searchTerm)).or(qUserAccount.organisation.contains(searchTerm)).or(qUserAccount.homePhone.contains(searchTerm)).or(qUserAccount.workPhone.contains(searchTerm)).or(qUserAccount.mobilePhone.contains(searchTerm)).or(qUserAccount.fax.contains(searchTerm)));
		if (searchTerm.contains(" ")) {
			String[] bits = searchTerm.split(" ");
			String firstname = bits[0];
			String lastname = bits[1];
			builder.or(qUserAccount.firstname.contains(firstname).and(qUserAccount.lastname.contains(lastname)));
		}
		query.where(builder);
		query.orderBy(qUserAccount.lastname.asc(), qUserAccount.firstname.asc());
		List<UserAccount> resultList = query.list(qUserAccount);
        long total = resultList.size();        
        query.offset(page.getOffset());
        query.limit(page.getPageSize());
        resultList = query.list(qUserAccount);
        Page<UserAccount> useerAccounts = new PageImpl<UserAccount>(resultList, page, total);
        return useerAccounts;
    }

    public Long countNotValidPermanently() {
    	JPAQuery query = new JPAQuery(userAccountRepository.getEntityManager());
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qUserAccount.validUntil.isNotNull());
		query.where(builder);
		Long count = 0L;
		count = query.singleResult(qUserAccount.count().as("count"));
        return count;
    }

    public Long countImported() {
    	JPAQuery query = new JPAQuery(userAccountRepository.getEntityManager());
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qUserAccount.imported.isTrue());
		query.where(builder);
		Long count = 0L;
		count = query.singleResult(qUserAccount.count().as("count"));
        return count;
    }

}
