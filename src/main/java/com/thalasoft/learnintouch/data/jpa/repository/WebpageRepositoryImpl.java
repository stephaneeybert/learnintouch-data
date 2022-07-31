package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.thalasoft.learnintouch.data.jpa.domain.QWebpage;
import com.thalasoft.learnintouch.data.jpa.domain.Webpage;

public class WebpageRepositoryImpl implements WebpageRepositoryCustom {

	@Autowired
	private WebpageRepository webpageRepository;

	@Override
	public Webpage findByNextListOrder(Webpage parent, int listOrder) {
    	JPAQuery query = new JPAQuery(webpageRepository.getEntityManager());
    	QWebpage qWebpage = QWebpage.webpage;
    	BooleanBuilder builder = new BooleanBuilder();
		if (parent != null) {
			builder.and(qWebpage.parent.eq(parent));
		} else {
			builder.and(qWebpage.parent.isNull());
		}
		builder.and(qWebpage.listOrder.gt(listOrder));
		query.where(builder);
		query.orderBy(qWebpage.listOrder.asc()).limit(1);
		Webpage webpage = query.uniqueResult(qWebpage);
        return webpage;
	}
		
	@Override
	public Webpage findByPreviousListOrder(Webpage parent, int listOrder) {
    	JPAQuery query = new JPAQuery(webpageRepository.getEntityManager());
    	QWebpage qWebpage = QWebpage.webpage;
    	BooleanBuilder builder = new BooleanBuilder();
		if (parent != null) {
			builder.and(qWebpage.parent.eq(parent));
		} else {
			builder.and(qWebpage.parent.isNull());
		}
		builder.and(qWebpage.listOrder.lt(listOrder));
		query.where(builder);
		query.orderBy(qWebpage.listOrder.desc()).limit(1);
		Webpage webpage = query.uniqueResult(qWebpage);
        return webpage;
	}
		
}
