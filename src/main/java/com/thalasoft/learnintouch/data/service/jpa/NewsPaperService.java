package com.thalasoft.learnintouch.data.service.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;

@Transactional
public interface NewsPaperService {
	
	public NewsPaper findById(Long id);
	
	public NewsPaper add(NewsPaper newsPaper) throws EntityNotFoundException;

	public NewsPaper delete(Long id) throws EntityNotFoundException;

}
