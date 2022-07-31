package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.thalasoft.learnintouch.data.jpa.domain.NewsHeading;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.domain.NewsStory;
import com.thalasoft.learnintouch.data.jpa.domain.QNewsStory;

public class NewsStoryRepositoryImpl implements NewsStoryRepositoryCustom {

	@Autowired
	private NewsStoryRepository newsStoryRepository;

	@Override
	public NewsStory findByNextListOrder(NewsPaper newsPaper, NewsHeading newsHeading, int listOrder) {
    	JPAQuery query = new JPAQuery(newsStoryRepository.getEntityManager());
    	QNewsStory qNewsStory = QNewsStory.newsStory;
    	query.from(qNewsStory);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qNewsStory.newsPaper.eq(newsPaper));
		if (newsHeading != null) {
			builder.and(qNewsStory.newsHeading.eq(newsHeading));
		} else {
			builder.and(qNewsStory.newsHeading.isNull());
		}
		builder.and(qNewsStory.listOrder.gt(listOrder));
		query.where(builder);
		query.orderBy(qNewsStory.listOrder.asc()).limit(1);
		NewsStory newsStory = query.uniqueResult(qNewsStory);
        return newsStory;
	}
		
	@Override
	public NewsStory findByPreviousListOrder(NewsPaper newsPaper, NewsHeading newsHeading, int listOrder) {
    	JPAQuery query = new JPAQuery(newsStoryRepository.getEntityManager());
    	QNewsStory qNewsStory = QNewsStory.newsStory;
        query.from(qNewsStory);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qNewsStory.newsPaper.eq(newsPaper));
		if (newsHeading != null) {
			builder.and(qNewsStory.newsHeading.eq(newsHeading));
		} else {
			builder.and(qNewsStory.newsHeading.isNull());
		}
		builder.and(qNewsStory.listOrder.lt(listOrder));
		query.where(builder);
		query.orderBy(qNewsStory.listOrder.desc()).limit(1);
		NewsStory newsStory = query.uniqueResult(qNewsStory);
        return newsStory;
	}
		
}
