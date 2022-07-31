package com.thalasoft.learnintouch.data.service.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPublication;

@Transactional
public interface NewsPublicationService {
	
	public NewsPublication findById(Long id);

	public NewsPublication add(NewsPublication newsPublication) throws EntityNotFoundException;

	public NewsPublication delete(Long id) throws EntityNotFoundException;
	
}
