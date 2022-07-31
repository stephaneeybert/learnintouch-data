package com.thalasoft.learnintouch.data.service.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.NewsHeading;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.domain.NewsStory;

@Transactional
public interface NewsStoryService {

	public NewsStory findByNextListOrder(NewsPaper newsPaper, NewsHeading newsHeading, int listOrder);
	
	public NewsStory findById(Long id);
	
	public NewsStory add(NewsStory newsStory) throws EntityNotFoundException;

	public NewsStory delete(Long id) throws EntityNotFoundException;
	
}
