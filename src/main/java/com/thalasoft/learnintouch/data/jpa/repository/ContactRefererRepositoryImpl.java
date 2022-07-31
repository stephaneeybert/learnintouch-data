package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysema.query.jpa.impl.JPAQuery;
import com.thalasoft.learnintouch.data.jpa.domain.ContactReferer;
import com.thalasoft.learnintouch.data.jpa.domain.QContactReferer;

public class ContactRefererRepositoryImpl implements ContactRefererRepositoryCustom {

	@Autowired
	private ContactRefererRepository contactRefererRepository;

	@Override
    public ContactReferer findFirst() {
    	JPAQuery query = new JPAQuery(contactRefererRepository.getEntityManager());
    	QContactReferer qQContactReferer = QContactReferer.contactReferer;
    	ContactReferer contactReferer = query.orderBy(qQContactReferer.listOrder.asc()).limit(1).uniqueResult(qQContactReferer);
        return contactReferer;
    }

	@Override
	public ContactReferer findByNextListOrder(int listOrder) {
    	JPAQuery query = new JPAQuery(contactRefererRepository.getEntityManager());
    	QContactReferer qQContactReferer = QContactReferer.contactReferer;
    	ContactReferer contactReferer = query.where(qQContactReferer.listOrder.gt(listOrder)).orderBy(qQContactReferer.listOrder.asc()).limit(1).uniqueResult(qQContactReferer);
        return contactReferer;
	}

	@Override
    public ContactReferer findByPreviousListOrder(int listOrder) {
    	JPAQuery query = new JPAQuery(contactRefererRepository.getEntityManager());
    	QContactReferer qQContactReferer = QContactReferer.contactReferer;
    	ContactReferer contactReferer = query.where(qQContactReferer.listOrder.lt(listOrder)).orderBy(qQContactReferer.listOrder.desc()).limit(1).uniqueResult(qQContactReferer);
        return contactReferer;
	}

}
