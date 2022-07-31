package com.thalasoft.learnintouch.data.service.jpa;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.NewsHeading;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.domain.NewsStory;
import com.thalasoft.learnintouch.data.jpa.repository.NewsStoryRepository;

@Service
public class NewsStoryServiceImpl implements NewsStoryService {

    private static Logger logger = LoggerFactory.getLogger(NewsStoryServiceImpl.class);

	@Resource
	private NewsStoryRepository newsStoryRepository;

	@Override
	public NewsStory findByNextListOrder(NewsPaper newsPaper, NewsHeading newsHeading, int listOrder) {
		return newsStoryRepository.findByNextListOrder(newsPaper, newsHeading, listOrder);         
	}

	@Override
	public NewsStory findById(Long id) {
		return newsStoryRepository.findOne(id);
	}
	
	@Modifying
	@Override
	public NewsStory add(NewsStory newsStory) {
    	// Save the returned id into the entity
		newsStory = newsStoryRepository.saveAndFlush(newsStory);
    	return newsStory;
	}
	
	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Override
	public NewsStory delete(Long id) throws EntityNotFoundException {
		NewsStory newsStory = findById(id);
        if (newsStory == null) {
        	throw new EntityNotFoundException();
        } else {
        	newsStoryRepository.delete(newsStory);
    		return newsStory;
        }
	}
	
}
