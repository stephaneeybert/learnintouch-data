package com.thalasoft.learnintouch.data.service.jpa;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.repository.NewsPaperRepository;

@Service
public class NewsPaperServiceImpl implements NewsPaperService {

	@Resource
	private NewsPaperRepository newsPaperRepository;

	@Override
	public NewsPaper findById(Long id) {
		return newsPaperRepository.findOne(id);
	}
	
	@Modifying
	@Override
	public NewsPaper add(NewsPaper newsPaper) {
    	// Save the returned id into the entity
		newsPaper = newsPaperRepository.saveAndFlush(newsPaper);
    	return newsPaper;
	}
	
	@Modifying
	@Transactional(rollbackFor = EntityNotFoundException.class)
	@Override
	public NewsPaper delete(Long id) throws EntityNotFoundException {
		NewsPaper newsPaper = findById(id);
        if (newsPaper == null) {
        	throw new EntityNotFoundException();
        } else {
        	newsPaperRepository.delete(newsPaper);
    		return newsPaper;
        }
	}
	
}
