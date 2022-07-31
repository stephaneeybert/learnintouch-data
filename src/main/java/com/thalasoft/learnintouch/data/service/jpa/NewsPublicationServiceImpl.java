package com.thalasoft.learnintouch.data.service.jpa;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPublication;
import com.thalasoft.learnintouch.data.jpa.repository.NewsPublicationRepository;

@Service
public class NewsPublicationServiceImpl implements NewsPublicationService {

	@Resource
	private NewsPublicationRepository newsPublicationRepository;

	@Override
	public NewsPublication findById(Long id) {
		return newsPublicationRepository.findOne(id);
	}
	
	@Modifying
	@Override
	public NewsPublication add(NewsPublication newsPublication) {
    	// Save the returned id into the entity
		newsPublication = newsPublicationRepository.saveAndFlush(newsPublication);
    	return newsPublication;
	}
	
	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Override
	public NewsPublication delete(Long id) throws EntityNotFoundException {
		NewsPublication newsPublication = findById(id);
        if (newsPublication == null) {
        	throw new EntityNotFoundException();
        } else {
        	newsPublicationRepository.delete(newsPublication);
    		return newsPublication;
        }
	}
	
}
